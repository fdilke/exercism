object Flattener {


  fun flatten(listWithNulls: List<Any?>): List<Any> {
    val list = listWithNulls.filterNotNull()

    return list.map { entry ->
      when(entry) {
        is List<Any?> -> flatten(entry)
        else -> listOf(entry)
      }
    }.flatten()
  }
}