fun main() {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var out = 0
        for (i in nums.indices step 2) out += nums[i]
        return out
    }
}