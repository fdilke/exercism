
class SpaceAge(val numSeconds: Long) {

    val secondsEarth = 31557600
    val mercuryYears = 0.2408467
    val venusYears = 0.61519726
    val marsYears = 1.8808158
    val jupiterYears = 11.862615
    val saturnYears = 29.447498
    val uranusYears = 84.016846
    val neptuneYears = 164.79132

    private fun to2DP(value: Double) =
            Math.floor(value * 100 + 0.5) / 100

    private fun yearsOnEarth(): Double =
            numSeconds.toDouble() / secondsEarth

    private fun convertWith(planetYears: Double) =
            to2DP(yearsOnEarth() / planetYears)

    fun onEarth(): Double =
            to2DP(yearsOnEarth())

    fun onMercury(): Double =
            convertWith(mercuryYears)

    fun onVenus(): Double =
            convertWith(venusYears)

    fun onMars(): Double =
            convertWith(marsYears)

    fun onJupiter(): Double =
            convertWith(jupiterYears)

    fun onSaturn(): Double =
            convertWith(saturnYears)

    fun onUranus(): Double =
            convertWith(uranusYears)

    fun onNeptune(): Double =
            convertWith(neptuneYears)

}