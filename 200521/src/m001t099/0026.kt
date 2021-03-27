fun main() {
    /**
     * API它不香吗
     * @param nums IntArray
     * @return Int
     */
    fun removeDuplicates0(nums: IntArray): Int {
        val tmp = nums.distinct()
        for (i in tmp.indices) nums[i] = tmp[i]
        return tmp.size
    }

    /**
     * solution 双指针
     * @param nums IntArray
     * @return Int
     */
    fun removeDuplicates(nums: IntArray): Int {
        val size = nums.size
        if (size < 2) return size
        var i = 1
        for (j in 0..size - 2) {
            if (nums[j] != nums[j + 1]) {
                nums[i] = nums[j + 1]
                i++
            }
        }
        return i
    }


}

