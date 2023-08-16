(ns clojurescript-website.content
  (:require
   [reagent.core :as reagent :refer [atom]]))

;; Application state
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defonce app-state (atom {:website {:title "Bismarckstraße 4 Wohnheim"
                                    :description "Welcome to our Studentenwohneheim!"}}))

;; Content components
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn welcome-page []
 [:section {:class "section"}
 
   [:h1
    {:class "title"}
    "Welcome to Bismarckstraße"]
 
    ;; Content will just use HTML tags directly, useful when you have no specific styles
    ;; https://bulma.io/documentation/elements/content/
 
   [:div {:class "content"}
    [:p
     "As a new-be in the dormitory you will most likely want to have all of the following:"]

    [:ul
     [:li "Get WiFi running"]
     [:li "Meet your floor-mates"]
     [:li "Know where to get help"] 
     [:li "Understand what these Germans are going on about (a.k.a. a crash course in German culture)"]
     [:li "Find out about or next HVV (house meeting)"]
     [:li "Look at our events calendar"]
     ]
    ;; design choice: make a separate page for each? Or make a big state to plug into a page function...?
    [:figure
     [:img {:src "images/bismarck.png"}]]
    ]])

(defn website-title []
  [:section {:class "jumbotron practicalli-jumbotron"}
   [:h1 (get-in @app-state [:website :title])]
   [:h4 (get-in @app-state [:website :description])]])

(defn navigation-top
  "A responsive navigation that is fixed to the top of the page"
  []

  [:nav {:class      "navbar is-fixed-top is-dark"
         :role       "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href  "/"}
      [:img {:src "images/bismarck.png"}]]
     [:span {:class       "navbar-burger burger"
             :data-target "navbarClojureBridge"}
      ;; Empty spans needed for navbar burger
      [:span] [:span] [:span]]]

    [:div {:id    "navbarClojureBridge"
           :class "navbar-menu"}
     [:div {:class "navbar-start"}
      [:a {:class "navbar-item"
           :href  "#overview"} "Overview"]
      [:a {:class "navbar-item"
           :href  "#events"} "Events"]
      [:a {:class "navbar-item"
           :href  "#wifi"} "WiFi"]
      [:a {:class "navbar-item"
           :href  "#getting-help"} "Getting Help"]
      [:a {:class "navbar-item"
           :href  "#learn-german"} "Learn German"]
      [:a {:class "navbar-item"
           :href  "#useful-links"} "Useful Links"]
      [:a {:class "navbar-item"
           :href  "#sponsors"} "Sponsors"]

      [:span {:class "navbar-item"}
       [:a {:class  "button is-inverted"
            :target "_blank"
            :href   "https://github.com/AndreasADL/clojurescript-website/tree/main/docs"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]
        [:span "Issues/PRs"]]]]]]])
