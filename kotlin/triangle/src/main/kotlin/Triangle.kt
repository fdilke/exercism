class Triangle(a: Number, b: Number, c: Number) {

    init {
        if ((a.toDouble() <= 0) or (b.toDouble() <= 0) or (c.toDouble() <= 0))
            throw IllegalArgumentException()

        if (
            violatesTriangleInequality(a,b,c) or
            violatesTriangleInequality(b,c,a) or
            violatesTriangleInequality(c,a,b)
        )
            throw IllegalArgumentException()
    }

    val isEquilateral: Boolean =
            (a == b) and (b == c)

    val isIsosceles: Boolean =
            (a == b) or (b == c) or (a == c)

    val isScalene: Boolean =
            (a != b) and (b != c) and (a != c)

    companion object {
        private fun violatesTriangleInequality(x: Number, y: Number, z: Number): Boolean =
                (x.toDouble() + y.toDouble()) <= z.toDouble()
    }
}