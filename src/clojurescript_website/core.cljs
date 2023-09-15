(ns ^:figwheel-hooks clojurescript-website.core
  (:require
   [goog.dom :as gdom]
   [goog.events :as geve]
   [reagent.core :as r]
   [reagent.dom :as rdom]
   [clojurescript-website.content :as content]
   [reitit.coercion.spec :as rss]
   [reitit.frontend :as rf]
   [reitit.frontend.easy :as rfe]
   ))

;; Application state
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (r/atom {:text "Hello world!"}))
(defonce route-state (r/atom nil))

;; simple debug statement for each build
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(println (js/Date.) "Reloading: core.cljs")
(println (js/Date.) (-> @route-state :data :view))

;; Helper functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;; Function to activate burger from the navbar menue upon event
(defn toggle-active [event]
  (let [burger (gdom/getElementByClass "burger")
        nav-id (.-dataset.target burger)
        nav (gdom/getElement nav-id)]
    (.classList.toggle burger "is-active")
    (.classList.toggle nav "is-active")))
;; Function to toggle burger active when clicked
(defn setup-burger-nav-toggle []
  (let [burger (gdom/getElementByClass "burger")]
    (geve/listen burger "click" toggle-active)))

(defn multiply [a b] (* a b))

;; Content components
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn navigation-top
  "A responsive navigation that is fixed to the top of the page"
  []
  [:nav {:class "navbar is-fixed-top is-dark"
         :role "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a.navbar-item {:href  (rfe/href ::home)}
      [:img {:src "images/bismarck.png"}]]
     [:span {:class       "navbar-burger burger"
             :data-target "navbarClojureBridge"}
      ;; Empty spans needed for navbar burger
      [:span] [:span] [:span]]]

    [:div {:id    "navbarClojureBridge"
           :class "navbar-menu"}
     [:div.navbar-start
      [:a.navbar-item {:href  (rfe/href ::welcome)} "Welcome"]
      [:a.navbar-item {:href  (rfe/href ::events)} "Events"]
      [:a.navbar-item {:href  (rfe/href ::wifi)} "WiFi"]
      [:a.navbar-item {:href  (rfe/href ::getting-help)} "Getting Help"]
      [:a.navbar-item {:href  (rfe/href ::learn-german)} "Learn German"]
      [:a.navbar-item {:href  (rfe/href ::links)} "Useful Links"]

      [:span.navbar-item
       [:a {:class "button is-inverted"
            :target "_blank"
            :href   "https://github.com/AndreasADL/clojurescript-website/tree/main/docs"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]
        [:span "Issues/PRs"]]]]]]])

(defn app []
  [:div 
  ;;  [content/navigation-top]
   [navigation-top]
   (let [current-view (-> @route-state :data :view)]
     [current-view])
   ])

;; define routes
(def routes
  [["/"
    {:name ::home 
     :view content/home-page}]
   ["/welcome"
    {:name ::welcome
     :view content/welcome-page}]
   ["/events"
    {:name ::events
     :view content/events-page}]
   ["/wifi"
    {:name ::wifi 
     :view content/wifi-page}]
   ["/getting-help"
    {:name ::getting-help
     :view content/help-page}]
   ["/learn-german"
    {:name ::learn-german
     :view content/learn_german-page}]
   ["/links"
    {:name ::links
     :view content/links-page}]
   ])

;; define router start
(defn router-start! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})
   (fn [matched-route] (reset! route-state matched-route))
  ;;  set to false to enable HistoryAPI
   {:use-fragment false}
   ))


;; System
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn mount [el] 
  (router-start!)
  (rdom/render [app] el))

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)
    (setup-burger-nav-toggle)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^:after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
