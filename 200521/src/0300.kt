fun main() {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var result = 1
        val dpList = IntArray(nums.size) { 1 }
        for (i in nums.indices) {
            for (j in 0..i) {
                if (nums[j] < nums[i]) {
                    dpList[i] = (dpList[j] + 1).coerceAtLeast(dpList[i])
                }
            }
            result = result.coerceAtLeast(dpList[i])
        }
        return result
    }

    val input0 = intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6) //6
    val input1 = intArrayOf(0, 1, 0, 3, 2, 3) // 4
    val input2 = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18) // 4
    println(lengthOfLIS(input0))
    println(lengthOfLIS(input1))
    println(lengthOfLIS(input2))

}