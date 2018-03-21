
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int): Classification {

    if (n <= 0)
        throw RuntimeException()

    val divisors = (1 .. (n/2)).filter { n % it == 0 }
    val sum = divisors.sum()

    return (
        if (sum == n)
            Classification.PERFECT
        else if (sum < n)
            Classification.DEFICIENT
        else
            Classification.ABUNDANT
    )
}
