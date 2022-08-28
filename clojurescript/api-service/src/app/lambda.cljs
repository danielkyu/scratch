(ns app.lambda)

(defn lambda-handler
  "Lambda handler function"
  [event context callback]
  (println event)
  (callback nil
            (clj->js {:statusCode 200
                      :body "Hello from CLJS Lambda Functions!"
                      :headers {}})))