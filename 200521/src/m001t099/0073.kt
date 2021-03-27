fun main() {
    fun setZeroes(matrix: Array<IntArray>) {
        val m = matrix[0].size
        val n = matrix.size
        var iFlag = false // 第一行全为 0
        var jFlag = false // 第一列全为 0
        if (matrix[0][0] == 0) { // 0 开始, 那么横纵第一行全为 0
            iFlag = true
            jFlag = true
        } else {
            for (i in 1 until n) if (matrix[i][0] == 0) {
                iFlag = true
                break
            }
            for (j in 1 until m) if (matrix[0][j] == 0) {
                jFlag = true
                break
            }
        }
        // 置 0
        for (i in 1 until n) for (j in 1 until m) if (matrix[i][j] == 0) {
            matrix[i][0] = 0
            matrix[0][j] = 0
        }
        // 二次置 0
        for (i in 1 until n) for (j in 1 until m) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0
        }
        // 根据最开始时候 第一行第一列置 0
        if (iFlag) for (i in 0 until n) matrix[i][0] = 0
        if (jFlag) for (j in 0 until m) matrix[0][j] = 0
    }
}