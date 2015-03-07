; Copyright (C) 2013, 2014, 2015 Dr. Thomas Schank  (DrTom@schank.ch, Thomas.Schank@algocon.ch)
; Licensed under the terms of the GNU Affero General Public License v3.
; See the "LICENSE.txt" file provided with this software.

(defproject cider-ci_reverse-proxy "1.0.0"
  :description "Cider-CI Reverse-Proxy"
  :license {:name "GNU AFFERO GENERAL PUBLIC LICENSE Version 3"
            :url "http://www.gnu.org/licenses/agpl-3.0.html"}
  :dependencies [
                 [cider-ci/clj-auth "2.2.2"]
                 [cider-ci/clj-utils "2.7.0"]
                 [com.cemerick/url "0.1.1"]
                 [drtom/clj-uuid "0.0.8"]
                 [drtom/honeysql "1.1.0"]
                 [org.apache.commons/commons-io "1.3.2"]
                 [org.clojure/core.incubator "0.1.3"]
                 [org.clojure/tools.nrepl "0.2.7"]
                 ]
  :source-paths [ "src"]
  :profiles {:dev 
             {:dependencies [[midje "1.6.3"]]
              :plugins [[lein-midje "3.1.1"]]
              :repositories [["tmp" {:url "http://maven-repo-tmp.drtom.ch" :snapshots false}]]
              :resource-paths ["../config" "./config" "./resources"]}
             :production
             {:resource-paths ["/etc/cider-ci" "../config" "./config" "./resources"]}} 
  :aot [cider-ci.reverse-proxy.main] 
  :main cider-ci.reverse-proxy.main 
  :jvm-opts ["-Xmx64m"]
  )