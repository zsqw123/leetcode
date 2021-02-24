fun main() {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        val n = A[0].size
        for (a in A) for (j in 0 until (n + 1) / 2) {
            val tmp = a[j]
            a[j] = a[n - 1 - j] xor 1
            a[n - 1 - j] = tmp xor 1
        }
        return A
    }
}