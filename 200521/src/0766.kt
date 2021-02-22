fun main() {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        for (i in 1 until m) for (j in 1 until n)
            if (matrix[i][j] != matrix[i - 1][j - 1]) return false
        return true
    }
}