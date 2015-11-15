(ns cljs-react.core
  (:require [reagent.core :as reagent :refer [atom]]
            [ajax.core :refer [GET]]))

(enable-console-print!)

;; Hard coded comments for data
;; (defonce app-state (atom {:data [{:id 1 :author "Pete Hunt" :text "This is one comment"}
;;                                  {:id 2 :author "Jordan Walke" :text "This is *another* comment"}]}))

;; To be populated by API call
(defonce app-state (atom {:comments []}))

(defn comment-item [props & children]
    [:div {:class "comment"}
     [:h2 {:class "commentAuthor"} (props :author)]
     children])

(defn create-comment [c]
  [comment-item {:key (c :id) :author (c :author)} (c :text)])

(defn comment-list []
  [:div {:class "commentList"}
   ; Reagent will re-render this component when comments is mutated
   (map create-comment (:comments @app-state))])

(defn comment-form []
  [:div {:class "commentForm"}])

(defn comment-box [props]
    ; Load comments and update app-state
    (GET (props :url)
         {:response-format :json
          :keywords? true
          :handler (fn [response]
                     (swap! app-state assoc :comments response))})
    [:div {:class "commentBox"}
      [comment-list]
      [comment-form]])

(reagent/render-component [comment-box {:url "/api/comments/"}]
                    (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
