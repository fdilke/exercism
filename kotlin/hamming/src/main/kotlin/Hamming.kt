
object Hamming {
    fun compute(
        text1: String,
        text2: String
    ): Int =
        if (text1.length != text2.length)
            throw IllegalArgumentException("left and right strands must be of equal length.")
        else
            (0 until text1.length).count {
                text1[it] != text2[it]
            }
}