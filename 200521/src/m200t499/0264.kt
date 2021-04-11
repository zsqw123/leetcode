package m200t499

fun main() {
    fun nthUglyNumber(n: Int): Int {
        val arr = IntArray(n + 1)
        arr[0] = 1
        var p2 = 0
        var p3 = 0
        var p5 = 0
        var i = 0
        while (i < n) {
            val a = arr[p2] * 2
            val b = arr[p3] * 3
            val c = arr[p5] * 5
            val min = minOf(a, minOf(b, c))
            arr[++i] = min
            if (min == a) p2++
            if (min == b) p3++
            if (min == c) p5++
        }
        return arr[n - 1]
    }
}