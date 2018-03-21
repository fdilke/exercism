import java.util.stream.Stream

object Prime {
  fun nth(i: Int) =
    if (i == 0)
      throw IllegalArgumentException("There is no zeroth prime.")
    else
      Sieve.primesUpTo(Math.ceil(2 * i  * Math.log(i.toDouble())).toInt() + 2)[i - 1]
}


class Sieve(
  val primesSoFar: List<Int>,
  val marked: List<Int>,
  val unmarked: List<Int>
) {
  companion object {
    fun primesUpTo(n: Int): List<Int> =
            Stream.iterate(
                    Sieve(
                            unmarked = (2 .. n).toList(),
                            marked = listOf(),
                            primesSoFar = listOf()
                    ),
                    { it.doStep() }
            ).filter(
                    { it.isComplete() }
            ).findFirst().get().primesSoFar
  }

  private fun doStep(): Sieve {
    val p = unmarked.get(0)
    val classified: Map<Boolean, List<Int>> =
            unmarked.drop(1).groupBy {
              it % p == 0
            }
    val multiples = classified.getOrDefault(true, listOf())
    val nonMultiples = classified.getOrDefault(false, listOf())
    return Sieve(
            unmarked = nonMultiples,
            marked = marked.plus(multiples),
            primesSoFar = primesSoFar.plus(p)
    )
  }

  fun isComplete(): Boolean =
          unmarked.isEmpty()
}
