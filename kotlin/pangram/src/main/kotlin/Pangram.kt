object Pangram {
    val alphabet =
            (0 until 26).map {
                (it + 'a'.toInt()).toChar()
            }

    fun isPangram(text: String): Boolean =
            alphabet.all { letter ->
                text.contains(letter) ||
                text.contains(letter.toUpperCase())
            }
}