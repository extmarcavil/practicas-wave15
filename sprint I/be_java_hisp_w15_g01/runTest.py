#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# archivo encargado de correr todos los test de la carpeta /test

import sys

import unittest

def run_functional_tests(pattern=None):
    print("Running tests...")
    if pattern is None:
        tests = unittest.defaultTestLoader.discover("test")
    else:
        pattern_with_globs = "%s" % (pattern,)
        tests = unittest.defaultTestLoader.discover("tests", pattern=pattern_with_globs)

    runner = unittest.TextTestRunner()
    runner.run(tests)

if __name__ == "__main__":
    if len(sys.argv) == 1:
        run_functional_tests()
    else:
        run_functional_tests(pattern=sys.argv[1])
