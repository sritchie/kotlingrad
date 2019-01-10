package edu.umontreal.kotlingrad.functions

import edu.umontreal.kotlingrad.algebra.Field

abstract class NullaryFunction<X: Field<X>>: Function<X>(emptySet())

abstract class UnaryFunction<X: Field<X>>(arg: Function<X>): Function<X>(arg.variables)

abstract class BinaryFunction<X: Field<X>>(val rfn: Function<X>, val lfn: Function<X>): Function<X>(rfn.variables + lfn.variables)

abstract class TernaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>): Function<X>(fn1.variables + fn2.variables + fn3.variables)
//
//abstract class QuaternaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>, val fn4: Function<X>): Function<X>
//
//abstract class QuinaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>, val fn4: Function<X>, val fn5: Function<X>): Function<X>
//
//abstract class SenaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>, val fn4: Function<X>, val fn5: Function<X>, val fn6: Function<X>): Function<X>
//
//abstract class SeptenaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>, val fn4: Function<X>, val fn5: Function<X>, val fn6: Function<X>, val fn7: Function<X>): Function<X>
//
//abstract class OctonaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>, val fn4: Function<X>, val fn5: Function<X>, val fn6: Function<X>, val fn7: Function<X>, val fn8: Function<X>): Function<X>
//
//abstract class NovenaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>, val fn4: Function<X>, val fn5: Function<X>, val fn6: Function<X>, val fn7: Function<X>, val fn8: Function<X>, val fn9: Function<X>): Function<X>
//
//abstract class DenaryFunction<X: Field<X>>(val fn1: Function<X>, val fn2: Function<X>, val fn3: Function<X>, val fn4: Function<X>, val fn5: Function<X>, val fn6: Function<X>, val fn7: Function<X>, val fn8: Function<X>, val fn9: Function<X>, val fn10: Function<X>): Function<X>