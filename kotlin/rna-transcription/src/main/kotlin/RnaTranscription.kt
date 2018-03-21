val charMap = mapOf(
        'C' to 'G',
        'G' to 'C',
        'T' to 'A',
        'A' to 'U'
)

val myMap: Map<Int, Int> =
  listOf(1, 2, 3).fold(
    mapOf(), {
      result, number ->
      result + (number to number * 2)
    }
  )

val a = println(myMap)

fun transcribeToRna(dna: String): String =
  dna.map {
      charMap.getOrDefault(it, it)
  }.joinToString("")



