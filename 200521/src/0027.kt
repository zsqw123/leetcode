fun main() {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0
        var i = 0
        for (j in nums.indices) if (nums[j] != `val`) {
            nums[i] = nums[j]
            i++
        }
        return i
    }
}