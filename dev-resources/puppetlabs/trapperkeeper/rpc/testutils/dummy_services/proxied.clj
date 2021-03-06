(ns puppetlabs.trapperkeeper.rpc.testutils.dummy-services.proxied
  (:require [puppetlabs.trapperkeeper.rpc.testutils.dummy-services :refer [RPCTestService]]
            [puppetlabs.trapperkeeper.rpc.core :refer [call-remote-svc-fn]]
            [puppetlabs.trapperkeeper.services :refer [defservice]]))

(defservice rpc-test-service-proxied
  RPCTestService
  [[:ConfigService get-in-config]]
  (add [this x y] (call-remote-svc-fn (get-in-config [:rpc]) :RPCTestService :add x y))
  (fun-divide [this x] (call-remote-svc-fn (get-in-config [:rpc]) :RPCTestService :fun-divide x)))
