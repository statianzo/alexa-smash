(ns smash.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [smash.tests]))

(doo-tests 'smash.tests)
