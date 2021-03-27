fun main() {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val iSize = triangle.size
        when (iSize) {
            0 -> return 0
            1 -> return triangle[0][0]
            2 -> return triangle[0][0] + triangle[1][0].coerceAtMost(triangle[1][1])
        }
        val tri = Array(iSize) { triangle[it].toTypedArray() }
        tri[1][0] = tri[0][0] + tri[1][0]
        tri[1][1] = tri[0][0] + tri[1][1]
        for (i in 2 until iSize) {
            tri[i][0] = tri[i - 1][0] + tri[i][0]
            tri[i][i] = tri[i - 1][i - 1] + tri[i][i]
            for (j in 1 until i) tri[i][j] = tri[i - 1][j - 1].coerceAtMost(tri[i - 1][j]) + tri[i][j]
        }
        return tri[iSize - 1].min()!!
    }

    val input = listOf(
            listOf(2),
            listOf(3, 4),
            listOf(6, 5, 7),
            listOf(4, 1, 8, 3)
    )

    println(minimumTotal(input))
}