(ns cljs-react.core
  (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:data [{:id 1 :name "Pete Hunt" :text "This is one comment"}
                                 {:id 2 :name "Jordan Walke" :text "This is *another* comment"}]}))

(defn comment-item [props children]
    [:div {:class "comment"}
     [:h2 {:class "commentAuthor"} (props :author)]
     children])

(defn create-comment [c]
  [comment-item {:key (c :id) :author (c :name)} (c :text)])

(defn comment-list [props]
  [:div {:class "commentList"}
   (map create-comment (props :data))])

(defn comment-form []
  [:div {:class "commentForm"}])

(defn comment-box [props]
  [:div {:class "commentBox"}
    [comment-list {:data (props :data)}]
    [comment-form]])

(reagent/render-component [comment-box {:data (@app-state :data)}]
                    (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
