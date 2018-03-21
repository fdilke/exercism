class DiamondPrinter {

  private fun reflectList(list: List<String>): List<String> {
    val length = list.size
    val prefix = list.subList(0, length - 1)
    return prefix + list.subList(length - 1, length) + prefix.reversed()
  }

  private fun reflect(text: String): String {
    val length = text.length
    val prefix = text.substring(0, length - 1)
    return prefix + text.substring(length - 1) + prefix.reversed()
  }

  fun printToList(endChar: Char): List<String> {
    val range = 'A' .. endChar
    val size = range.count()
    return reflectList(
      range.mapIndexed { i, ch ->
        reflect(" ".repeat(size - i - 1) + ch + " ".repeat(i))
      }
    )
  }

}
