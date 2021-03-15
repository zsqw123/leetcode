fun main() {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = arrayListOf<Int>()
        var curXMin = 0
        var curYMin = 0
        var curYMax = matrix.size - 1
        var curXMax = matrix[0].size - 1
        var count = 0
        while (curXMin <= curXMax && curYMin <= curYMax) {
            when (count % 4) {
                0 -> {
                    for (i in curXMin..curXMax) res.add(matrix[curYMin][i])
                    ++curYMin
                }
                1 -> {
                    for (i in curYMin..curYMax) res.add(matrix[i][curXMax])
                    --curXMax
                }
                2 -> {
                    for (i in curXMax-- downTo curXMin) res.add(matrix[curYMax][i])
                    --curYMax
                }
                3 -> {
                    for (i in curYMax downTo curYMin) res.add(matrix[i][curXMin])
                    ++curXMin
                }
            }
            count++
        }
        return res
    }

    val testCase0 = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
    spiralOrder(testCase0).forEach { println(it) }
}