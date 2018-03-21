import java.math.BigInteger

object Board {

    private val TWO = BigInteger.valueOf(2)

    fun getGrainCountForSquare(square: Int): BigInteger =
        if ((square <= 0) or (square > 64))
            throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
        else
            TWO.pow(square - 1)

    fun getTotalGrainCount(): BigInteger =
        TWO.pow(64).minus(BigInteger.ONE)
}