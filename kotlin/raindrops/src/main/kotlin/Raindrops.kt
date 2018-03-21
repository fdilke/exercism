
object Raindrops {
    private val factorMappings = mapOf(
            3 to "Pling",
            5 to "Plang",
            7 to "Plong"
    )
    fun convert(input: Int): String {
        val filtered = factorMappings.map { entry ->
            val factor = entry.key
            val string = entry.value

            if (input % factor == 0)
                string
            else
                null
        }.filterNotNull()

        println("Filtered for ${input} = ${filtered}")
        return if (filtered.isEmpty())
            input.toString()
        else
            filtered.joinToString ( "" )
    }
}

fun main(args: Array<String>) {
    val g = listOf("ab", "cb", "ef")
    println("${ g.joinToString("") }")

}