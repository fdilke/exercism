import java.util.stream.Stream

object CollatzCalculator {

  private fun step(n: Int) =
    if (n % 2 == 0)
      n / 2
    else
      3 * n  + 1

  fun computeStepCount(n: Int): Int =
    if (n <= 0)
      throw IllegalArgumentException("Only natural numbers are allowed")
    else
      Stream.iterate(
        Iteration(n, 0),
        { it.step() }
      ).filter {
        it.value == 1
      }.findFirst().get().numSteps

  class Iteration(
    val value: Int,
    val numSteps: Int
  ) {
    fun step(): Iteration =
      Iteration(
         step(value),
        numSteps + 1
      )
  }
}