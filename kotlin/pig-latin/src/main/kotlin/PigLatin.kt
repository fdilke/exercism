
object PigLatin {

  private const val vowels = "aeiou"

  private val consonantPrefixes =
    listOf(
      "ch", "qu", "squ", "thr", "sch", "th", "rh"
    )

  private val vowelPrefixes =
    listOf(
      "yt", "xr"
    ).plus(vowels.toList().map{ it.toString() })

  fun translateWord(text: String): String {
    val length = text.length

    val consonantPrefix =
      consonantPrefixes.find { text.startsWith(it) }
    val vowelPrefix =
      vowelPrefixes.find { text.startsWith(it) }

    when {
      consonantPrefix != null ->
        return text.substring(consonantPrefix.length, length) + consonantPrefix + "ay"
      vowelPrefix != null ->
        return text + "ay"
      else ->
        return text.substring(1, length) + text[0] + "ay"
    }

    // text.substring(1, length) + text[0] + ""
  }

  fun translate(text: String): String =
    text.split(" ").map(
      this::translateWord
    ).joinToString(" ")
}