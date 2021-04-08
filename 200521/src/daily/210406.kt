package daily

fun main() {
    // 反转二进制数
    fun reverse(input: Int): Int {
        var res = 0
        for (i in 0..31) res = (res shl 1) + (((1 shl i) and input) ushr i)
        return res
    }
    print(Integer.toBinaryString(reverse((0x7fffffff shl 1) + 1)))
}
