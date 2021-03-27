fun main() {
    fun isMonotonic(A: IntArray): Boolean {
        return if (A.first() > A.last()) A.contentEquals(A.sortedArrayDescending()) else A.contentEquals(A.sortedArray())
    }
}