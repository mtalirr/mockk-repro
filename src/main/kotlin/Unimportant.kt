class Unimportant {
    var a: Double = 0.0
    var b: Double = 0.0

    fun unimportantFn(other: Unimportant): Double {
        return degreesToRadians(other.a - this.b)
    }
}
