(defproject clojurescript-website "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.11.4"]
                 [cljsjs/react "17.0.2-0"]
                 [cljsjs/react-dom "17.0.2-0"]
                 [reagent "1.1.1" ]
                ;;  main routing
                 [metosin/reitit "0.5.11"]
                ;;  data coercion / validation
                 [metosin/reitit-spec "0.5.11"]
                ;;  frontend routing
                 [metosin/reitit-frontend "0.5.11"]
                 ]

  :source-paths ["src"]

  :aliases {"fig:build"  ["run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"    ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "fig:deploy" ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "deploy"]
            "fig:test"   ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" "clojurescript-website.test-runner"]}

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.2.17"]
                                  [org.slf4j/slf4j-nop "1.7.30"]]
                   
                   :resource-paths ["target"]
                   ;; need to add the compiled assets to the :clean-targets
                   :clean-targets ^{:protect false} ["target"]}})

