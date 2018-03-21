
class Series(digitString: String) {

    init {
        if (digitString.any {
                    !(it.isDigit())
                })
            throw IllegalArgumentException()
    }

    private val digits: List<Int> =
        digitString.map {
            it.toInt() - '0'.toInt()
        }

    fun consecutives(numConsecutive: Int): List<List<Int>> =
        (0 .. (digits.size - numConsecutive)).map { i ->
            digits.subList(i, i + numConsecutive)
        }

    companion object {
        fun product(list: List<Int>): Int =
            list.fold(
        1,
                { acc, x ->
                    acc * x
                }
            )
    }

    fun getLargestProduct(numConsecutive: Int): Int =
        if (numConsecutive > digits.size)
            throw IllegalArgumentException()
        else
            consecutives(numConsecutive).map {
                product(it)
            }.max()!!
}