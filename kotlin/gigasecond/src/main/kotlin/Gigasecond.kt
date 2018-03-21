import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal

class Gigasecond(
    startDate: LocalDateTime
) {
    constructor(date: LocalDate):
            this(date.atStartOfDay())

    private val GIGA =
            1e9.toLong()

    val date: Temporal =
            startDate.plus(GIGA, ChronoUnit.SECONDS)
}