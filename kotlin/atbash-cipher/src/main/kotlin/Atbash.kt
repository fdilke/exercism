object Atbash {

  private val cipher =
    "zyxwvutsrqponmlkjihgfedcba"

//  private fun despace(text: String): String =
//    text.replace(" ", "")

  private fun lettersAndDigitsOnly(text: String): String =
    text.filter {
      it.isLetterOrDigit()
    }

  private fun encodeChar(ch: Char): Char =
    if (ch.isDigit())
      ch
    else
      cipher[ch.toInt() - 'a'.toInt()]

  fun encode(text: String): String =
    lettersAndDigitsOnly(text).toLowerCase().map (
      this::encodeChar
    ).joinToString(
""
    ).chunked(
  5
    ).joinToString(
" "
    )

  fun decode(text: String): String =
    lettersAndDigitsOnly(text).toLowerCase().map (
            this::encodeChar
    ).joinToString(
            ""
    )
}