fun main() {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size - 1
        // 向右走变大, 向上变小
        // 为什么不能向左向下走呢?
        //      ->可以将右下角当作一个排序二叉树!! 妙啊!!!!
        var x = 0
        var y = matrix[0].size - 1
        while (y >= 0 && x <= n) when {
            matrix[x][y] > target -> y--
            matrix[x][y] < target -> x++
            else -> return true
        }
        return false
    }

    fun searchMatrix0(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix[0].size - 1
        val n = matrix.size - 1
        val searched = Array(n + 1) { BooleanArray(m + 1) }

        // 左1 上2 右3 下4
        tailrec fun find(x: Int, y: Int, orientation: Int): Boolean {
            if (x !in 0..m || y !in 0..n) return false
            if (searched[y][x]) return false
            searched[y][x] = true
            return when {
                matrix[y][x] > target -> when (orientation) {
                    1 -> find(x, y - 1, 4)
                    2 -> find(x - 1, y, 3)
                    else -> find(x - 1, y, 3) || find(x, y - 1, 4)
                }
                matrix[y][x] < target -> when (orientation) {
                    3 -> find(x, y + 1, 2)
                    4 -> find(x + 1, y, 1)
                    else -> find(x + 1, y, 1) || find(x, y + 1, 2)
                }
                else -> true
            }
        }
        return find(m / 2, n / 2, 0) || find(m / 2, n / 2, 0)
    }
}