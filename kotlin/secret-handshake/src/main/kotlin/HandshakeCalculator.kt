import com.sun.org.apache.xpath.internal.operations.Bool

object HandshakeCalculator {

    private val mappings = listOf(
        1 to Signal.WINK,
        2 to Signal.DOUBLE_BLINK,
        4 to Signal.CLOSE_YOUR_EYES,
        8 to Signal.JUMP
    )

    private val REVERSE = 16

    fun calculateHandshake(n: Int): List<Signal> {
        fun isFlagSet(flag: Int): Boolean =
                (n and flag) > 0

        val signals: List<Signal> =
            mappings.map { (value, signal) ->
                if (isFlagSet(value))
                    signal
                else
                    null

            }.filterNotNull()

        return (
            if (isFlagSet(REVERSE))
                signals.reversed()
            else
                signals
        )
    }
}