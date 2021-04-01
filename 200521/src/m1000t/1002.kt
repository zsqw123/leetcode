package m1000t

fun main() {
    fun clumsy(N: Int) = when (N) {
        1 -> 1
        2 -> 2
        3 -> 6
        4 -> 7
        else -> when {
            N % 4 == 0 -> N + 1
            N % 4 <= 2 -> N + 2
            else -> N - 1
        }
    }
}
