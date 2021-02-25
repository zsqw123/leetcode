fun main() {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val res = Array(matrix[0].size) { IntArray(matrix.size) }
        for (i in matrix[0].indices) for (j in matrix.indices)
            res[i][j] = matrix[j][i]
        return res
    }
}