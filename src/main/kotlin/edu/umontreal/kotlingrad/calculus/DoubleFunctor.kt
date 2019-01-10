package edu.umontreal.kotlingrad.calculus

import edu.umontreal.kotlingrad.functions.BinaryFunction
import edu.umontreal.kotlingrad.functions.Function
import edu.umontreal.kotlingrad.functions.TernaryFunction
import edu.umontreal.kotlingrad.functions.types.Const
import edu.umontreal.kotlingrad.functions.types.Var
import edu.umontreal.kotlingrad.numerical.DoubleReal
import edu.umontreal.kotlingrad.numerical.ProtoDouble

object DoubleFunctor: RealFunctor<DoubleReal>(ProtoDouble) {
  fun variable(default: Number) = Var(rfc, DoubleReal(default.toDouble()))

  fun variable(name: String, default: Number) =
      Var(rfc, DoubleReal(default.toDouble()), name)

  fun pow(base: Function<DoubleReal>, number: Int): TernaryFunction<DoubleReal> =
      pow(base, Const(DoubleReal(number), rfc))

  operator fun Function<DoubleReal>.invoke(pairs: Map<Var<DoubleReal>, Number>) =
      this(pairs.map { (it.key to DoubleReal(it.value)) }.toMap()).dbl

  operator fun Function<DoubleReal>.invoke(vararg pairs: Pair<Var<DoubleReal>, Number>) =
      this(pairs.map { (it.first to DoubleReal(it.second)) }.toMap()).dbl

  operator fun Function<DoubleReal>.invoke(vararg number: Number) =
      this(variables.zip(number).toMap())

  // TODO: Lift these into RealFunctor, perhaps extending from Field?
  operator fun Function<DoubleReal>.plus(number: Number) = this + Const(DoubleReal(number), rfc)

  operator fun Function<DoubleReal>.minus(number: Number) = this - Const(DoubleReal(number), rfc)

  operator fun Function<DoubleReal>.times(number: Number) = this * Const(DoubleReal(number), rfc)

  operator fun Function<DoubleReal>.div(number: Number) = this / value(DoubleReal(number))
}