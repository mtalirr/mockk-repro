import kotlin.math.*

class Location {
    var y: Double = 0.0
    var x: Double = 0.0

    fun distance(other: Location): Double {
        val dLat = degreesToRadians(other.y - this.y)
        val dLon = degreesToRadians(other.x - this.x)
        val lat1 = degreesToRadians(this.y)
        val lat2 = degreesToRadians(other.y)

        val a = sin(dLat / 2).pow(2) + sin(dLon / 2).pow(2) * cos(lat1) * cos(lat2)

        val output = (2 * atan2(sqrt(a), sqrt(1 - a))) * (6371008.8 * 3.28084)

        return output
    }

    override fun toString(): String {
        return "Location(y=$y, x=$x)"
    }
}

