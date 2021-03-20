package interview

fun main() {
    fun majorityElement0(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }

    fun majorityElement(nums: IntArray): Int {
        var nb = nums[0]
        var count = 1
        for (num in nums) {
            if (nb == num) count++
            else if (--count == 0) {
                nb = num
                count = 1
            }
        }
        return nb
    }
}