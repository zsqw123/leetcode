fun main() {
    fun myPow(x: Double, n: Int): Double {
        var res = 1.0
        var x0 = x
        var i = n
        while (i != 0) {
            if (i % 2 != 0) res *= x0
            x0 *= x0
            i /= 2
        }
        return if (n < 0) 1 / res else res
    }
}
