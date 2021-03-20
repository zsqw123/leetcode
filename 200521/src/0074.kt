fun main() {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var low = 0
        var high = matrix.size-1
        var half = (high + low) / 2
        while (low <= high) {
            when {
                matrix[half][0] > target -> {
                    high = half - 1
                    half = (high + low) / 2
                }
                matrix[half][0] < target -> {
                    low = half + 1
                    half = (high + low) / 2
                }
                else -> return true
            }
        }
        val row = half
        low = 0
        high = matrix[0].size-1
        half = (high + low) / 2
        while (low <= high) {
            when {
                matrix[row][half] > target -> {
                    high = half - 1
                    half = (high + low) / 2
                }
                matrix[row][half] < target -> {
                    low = half + 1
                    half = (high + low) / 2
                }
                else -> return true
            }
        }
        return false
    }
}