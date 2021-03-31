package m200t499

fun main() {
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid[0].size // j
        val n = grid.size // i
        var res = 0

        fun toZero(i: Int, j: Int) {
            if (i !in 0 until n || j !in 0 until m) return
            if (grid[i][j] == '0') return
            grid[i][j] = '0'
            toZero(i - 1, j)
            toZero(i, j - 1)
            toZero(i, j + 1)
            toZero(i + 1, j)
        }

        for (i in 0 until n) for (j in 0 until m) {
            if (grid[i][j] == '1') {
                res++
                toZero(i, j)
            }
        }
        return res
    }
}