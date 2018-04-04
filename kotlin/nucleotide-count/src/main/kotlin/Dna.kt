class Dna(text: String) {
  private val nucleotides: List<Char> =
    "ACGT".toList()

  init {
    if (!text.toList().minus(nucleotides).isEmpty())
      throw IllegalArgumentException()
  }

  val nucleotideCounts: Map<Char, Int> =
    nucleotides.map { ch ->
      Pair(ch, text.toList().count {
        it == ch
      })
    }.toMap()
}