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
     [:img.responsive {:src "images/bismarck.png"}]]
    ]])

(defn website-title []
  [:section {:class "jumbotron practicalli-jumbotron"}
   [:h1 (get-in @app-state [:website :title])]
   [:h4 (get-in @app-state [:website :description])]])


(defn home-page []
  [welcome-page])

(defn events-page []
  [:section.section
   [:h1.title "Events at Student Dormitory"]
   [:div.content
    [:p "Welcome to the student-run student dormitory! We host exciting events in our cozy bar."]
    [:p "Stay informed by joining our WhatsApp group and connecting with our Event Mentor."]
    [:p "For event details and schedules, check the information posted next to the entrance door."]
    [:figure
     [:img.responsive {:src "images/events.jpg" :alt "Events at the dorm"}]]]])

(defn wifi-page []
  [:section.section
   [:h1.title "Internet Access Information"]
   [:div.content
    [:p "Getting connected to the internet is crucial. Follow these steps to set up your Wi-Fi:"]
    [:ol
     [:li "Refer to the instructions for internet access at:"
      [:a {:href "https://stw-bonn.de/en/support/firststeps/start"} "stw-bonn.de"]]
     [:li "Ensure you have your rental contract ready and own a router. We recommend models found "
      [:a {:href "https://stw-bonn.de/en/support/internet/wlan_basic"} "here"]]
     [:li "Consider reaching out to your neighbors for help with internet setup. You might make a new friend! ;-)"]
     [:li "For additional assistance, contact our internet mentors. You can find their details by the front door."]]
    [:p "Stay connected and enjoy your time at the dorm!"]
    [:figure
     [:img.responsive {:src "images/wifi.jpg" :alt "Wi-Fi setup"}]]]])

(defn help-page []
  [:section.section
   [:h1.title "Need Help? We've Got You Covered!"]
   [:div.content
    [:p "Don't hesitate to reach out if you need assistance during your stay. Here are some options to get help:"]
    [:ul
     [:li "Ask your floor neighbors for help. Most people are kind and ready to assist. Getting to know your neighbors is key to a pleasant experience. Check if your floor has a WhatsApp group to connect with others."]
     [:li "Contact the Dorm Mentors for help with just about anything. You can find their responsibilities and contact details posted by the front door."]
     [:li "For various matters, you can ask Herr J. Jackisch, our House master. For quicker responses, consider writing in German (you can use Deepl.com for translation), keep emails concise, clear, and limit requests to one per email. This helps ensure a swift response."]
     [:li "For general inquiries and support, you can also reach out to Studierendenwerk, who provide services for students in need."]]
    [:p "Remember, we're here to make your stay comfortable and enjoyable. Don't hesitate to ask for help!"]
    [:figure
     [:img.responsive {:src "images/help.jpg" :alt "Getting help at the dorm"}]]]])

(defn learn_german-page []
  [:section.section
   [:h1.title "Learn German, Embrace the Culture!"]
   [:div.content
    [:p "While staying in a foreign country, learning the language can be both fun and incredibly useful. Here are some tips to help you on your language-learning journey:"]
    [:ul
     [:li "Don't be afraid to attempt learning German. Everyone understands that it can be challenging, but making the effort goes a long way in building connections and enjoying your experience."]
     [:li "Ask your German floormates if they can teach you. You'd be surprised at how much you can learn from casual conversations with locals."]
     [:li "The key to language learning is comprehensive input. Surround yourself with the language in situations you can understand. Challenge yourself to ask questions in the local shop, print out the lyrics of a German song you like and translate every word, and more. Remember, you're your own teacher, and it should be an enjoyable process. Don't rush it; progress is more important than speed."]]
    [:p "Learning a new language can be a rewarding adventure. Take it one step at a time, and you'll find yourself growing in competence and enjoying the process."]
    [:figure
     [:img.responsive {:src "images/learn_german.jpg" :alt "Learning German at the dorm"}]]]])

(defn links-page []
  [:section.section
    [:h1.title "Useful Links"]
    [:div.content
      [:p "Here are some links that will be helpful during your stay at Bismarckstraße:"]
      [:ul
        [:li [:a {:href "https://stw-bonn.de/"} "Internet Access Information"]]
        [:li [:a {:href "https://www.studierendenwerk-bonn.de/wohnen/unsere-wohnheime/wohnheim/bismarckstrasse-4-53113-bonn"} "Contact of Responsible Sachbearbeiter"]]
        [:li [:a {:href "https://sv.stw-bonn.de/wp/"} "Understanding Mentor Roles"]]
      ]
      [:p "Additionally, remember that valuable information is often posted at the entrance door, so be sure to check there as well."]
      [:figure
        [:img.responsive {:src "images/links.jpg" :alt "Useful links at the dorm"}]]]])

