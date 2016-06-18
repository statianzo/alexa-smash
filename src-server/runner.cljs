(ns workit.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [workit.tests]))

(doo-tests 'workit.tests)
