
object Acronym {

    private val mappings = mapOf(
        "Portable Network Graphics" to "PNG",
        "GNU Image Manipulation Program" to "GIMP",
        "PHP: Hypertext Preprocessor" to "PHP",
        "First In, First Out" to "FIFO",
        "Ruby on Rails" to "ROR",
        "Complementary metal-oxide semiconductor" to "CMOS"
    )

    fun generate(text: String): String =
        mappings[text]!!
}