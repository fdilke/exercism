class PhoneNumber(
  text: String
) {

  companion object {
    private val unwantedCharacters: List<Char> =
      "() -+.".toList()

    fun purge(text: String): String =
      unwantedCharacters.fold(
        text,
        { string, ch ->
          string.replace(ch.toString(), "")
        }
      )
  }

  private val revisedText =
    purge(text)

  private val length =
    revisedText.length

  private val allDigits: Boolean =
    revisedText.all { it.isDigit() }

  val number: String? =
    if (!allDigits)
      null
    else
      when(length) {
        10 ->
          when (revisedText[0]) {
            '0' -> null
            '1' -> null
            else ->
              when (revisedText[3]) {
                '0' -> null
                '1' -> null
                else -> revisedText
              }
          }
        11 ->
          if (revisedText[0] == '1')
            revisedText.drop(1)
          else
            null
        else -> null
      }
}