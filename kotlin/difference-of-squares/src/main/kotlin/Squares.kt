class Squares(val n: Int) {
    val range: IntRange = 1 .. n

    companion object {
        private val square: (Int) -> Int = {
            it * it
        }
    }

    fun sumOfSquares(): Int =
        range.map(square).sum()

    fun squareOfSum(): Int =
        square(
            range.sum()
        )

    fun difference(): Int =
        squareOfSum() - sumOfSquares()
}