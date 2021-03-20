package interview

fun main() {
    fun singleNumber(nums: IntArray): Int {
        var num = 0
        // 根据位运算交换律, 交换过以后相同的会被抵消
        for (i in nums) num = num xor i
        return num
    }

    val input = intArrayOf(3, 2, 1, 3, 2, 4, 4, 5, 6, 7, 7, 6, 5)
    println(singleNumber(input))
}