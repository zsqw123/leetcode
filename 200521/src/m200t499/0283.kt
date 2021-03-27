fun main() {
    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        for (j in nums.indices) {
            if (nums[j] != 0) {
                nums[i] = nums[j]
                i++
            }
        }
        for (j in i until nums.size)  nums[j] = 0
    }

    val array = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(array)
    array.forEach { print(it) }
}