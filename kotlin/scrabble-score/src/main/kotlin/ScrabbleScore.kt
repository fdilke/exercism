import java.util.HashMap

object ScrabbleScore {

    private val rawMappings = mapOf(
        "AEIOULNRST" to 1,
        "DG" to 2,
        "BCMP" to 3,
        "FHVWY" to 4,
        "K" to 5,
        "JX" to 8,
        "QZ" to 10
    )

    private val mappings = HashMap<Char, Int>()

    init {
        for ((letters, score) in rawMappings) {
            for (letter in letters)
                mappings.put(letter, score)
        }
    }

    fun scoreWord(text: String): Int =
            text.map { mappings[it.toUpperCase()] ?: 0 }.sum()
}