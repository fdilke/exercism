object SumOfMultiples {
    fun sum(divisors: Set<Int>, n: Int): Int =
        multiples(divisors, n).sum()

    fun multiples(divisors: Set<Int>, n: Int): List<Int> =
        (1 until n).filter { multiple ->
            divisors.find { divisor ->
                multiple % divisor == 0
            } != null
        }
}

fun main(args: Array<String>) {
    println(SumOfMultiples.multiples(setOf(3,5), 10))
}