
object WordCount {
  fun phrase(
    text: String
  ): Map<String, Int> =
      text.split(
        "[\\s,:=!@$%^&\\.]+".toRegex()
      ).filterNot {
        it.isEmpty()
      }.map {
        it.toLowerCase()
      }.map {
        if (it.startsWith("\'") and it.endsWith("\'"))
          it.drop(1).reversed().drop(1).reversed()
        else
          it
      }.groupBy {
          it
      }.mapValues {
        it.value.size
      }
}