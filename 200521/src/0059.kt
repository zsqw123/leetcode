fun main() {
    fun generateMatrix(n: Int): Array<IntArray> {
        val out = Array(n) { IntArray(n) }
        var curXMin = 0
        var curYMin = 0
        var curYMax = n - 1
        var curXMax = curYMax
        var count = 0
        var now = 0
        while (curXMin <= curXMax && curYMin <= curYMax) {
            when (count % 4) {
                0 -> {
                    for (i in curXMin..curXMax) out[curYMin][i] = ++now
                    ++curYMin
                }
                1 -> {
                    for (i in curYMin..curYMax) out[i][curXMax] = ++now
                    --curXMax
                }
                2 -> {
                    for (i in curXMax downTo curXMin) out[curYMax][i] = ++now
                    --curYMax
                }
                3 -> {
                    for (i in curYMax downTo curYMin) out[i][curXMin] = ++now
                    ++curXMin
                }
            }
            count++
        }
        return out
    }
    generateMatrix(6).forEach { it.forEach { v -> print(v) };println() }
}