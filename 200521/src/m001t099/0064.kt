fun main() {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return grid[0].sum()
        if (grid[0].size == 1) {
            var sum = 0
            for (i in grid) sum += i[0]
            return sum
        }
        for (i in 1 until grid[0].size) {
            grid[0][i] = grid[0][i] + grid[0][i - 1]
        }
        for (i in 1 until grid.size) {
            grid[i][0] = grid[i - 1][0] + grid[i][0]
            for (j in 1 until grid[i].size) {
                grid[i][j] = grid[i][j] + if (grid[i][j - 1] > grid[i - 1][j]) grid[i - 1][j] else grid[i][j - 1]
            }
        }
        return grid.last().last()
    }

    val input = arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
    )

    println(minPathSum(input))
}