
object Luhn {

    fun withoutSpaces(text: String): String =
            text.map { ch ->
                if (ch == ' ')
                    null
                else
                    ch
            }.filterNotNull().joinToString("")

    fun digitsOf(text: String): List<Int> =
        text.map { ch ->
            if (ch.isDigit())
                ch.toInt() - '0'.toInt()
            else if (ch == ' ')
                null
            else
                throw IllegalArgumentException()
        }.filterNotNull()

    fun carried(number: Int): Int =
        if (number > 9)
            number - 9
        else
            number

    fun doubleAlternates(numbers: List<Int>): List<Int> =
        numbers.reversed().mapIndexed { index, value ->
            if (index % 2 == 1)
            carried(value * 2)
            else
                value
        }.reversed()

    fun isValid(text: String): Boolean {
        val stripped = withoutSpaces(text)
        if (stripped.length <= 1)
            return false

        return try {
            val digits = digitsOf(stripped)
            (doubleAlternates(digits).sum() % 10 == 0)
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}