package m100t199

fun main() {
    fun reverseBits(n: Int): Int {
        var res = 0
        repeat(32) {
            res = (res shl 1) + ((n ushr it) and 1)
        }
        return res
    }
}