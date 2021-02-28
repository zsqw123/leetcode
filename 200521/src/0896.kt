fun main() {
    fun isMonotonic(A: IntArray): Boolean {
        return A.contentEquals(A.sortedArray()) || A.contentEquals(A.sortedArrayDescending())
    }
}