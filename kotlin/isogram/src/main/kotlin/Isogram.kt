
object Isogram {
  private fun isMeaningfulCharacter(ch: Char) =
          (ch != ' ') and (ch != '-')

  fun isIsogram(text: String) : Boolean {

    val coreText =
      text.toLowerCase().filter {
        isMeaningfulCharacter(it)
      }

    return coreText.toSet().size == coreText.length
  }
}