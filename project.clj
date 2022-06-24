(defproject nl.jomco/ring-openapi-validator "0.1.3"
  :description "Validate ring requests and responses against Swagger/OpenAPI"
  :url "https://git.sr.ht/~jomco/ring-openapi-validator"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[com.atlassian.oai/swagger-request-validator-core "2.28.1"]
                 [io.swagger.parser.v3/swagger-parser "2.1.1"]]
  :profiles {:dev {:resource-paths ["dev-resources"]
                   :dependencies [[clj-kondo "2022.06.22"]]
                   :plugins      [[lein-kibit "0.1.8"]
                                  [lein-ancient "1.0.0-RC3"]]
                   :aliases      {"lint" ["do"
                                          ["run" "-m" "clj-kondo.main" "--lint" "src"]
                                          "kibit"]}}
             :provided {:dependencies [[org.clojure/clojure "1.11.1"]]}}

  ;; setup `vX.Y.Z` tags, deploy to clojars
  :release-tasks [["vcs" "assert-committed"]
                  ["test"]
                  ["lint"]
                  ["ancient"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "v"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  ;; link to git repo, also ensures that cljdoc.org finds additional markdown files
  :scm {:name "git"
        :url  "https://git.sr.ht/~jomco/ring-openapi-validator"})
