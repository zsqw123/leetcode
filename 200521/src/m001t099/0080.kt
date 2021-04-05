package m001t099

fun main() {
    // 我思路比较简单...
    // 遍历遇到不等于当前数起点的结束值就将 end+相等的数量(最多为2)
    // 然后两个以内的相等的就追加到 end 后面
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var nowNumStart = 0
        var end = 0
        var count = 0
        for (i in nums.indices) {
            if (nums[i] != nums[nowNumStart]) {
                end += count
                count = 0
                nowNumStart = i
            }
            if (count < 2) {
                nums[end + count++] = nums[i]
            }
        }
        return end + count
    }

    // 其实根据上面那个我们优化后可以得出下面的
    // 合法数据会被筛选出来并参与`小数组`的 index
    fun removeDuplicates0(nums: IntArray): Int {
        var i = 0 // `小数组`的 index
        for (n in nums) if (i < 2 || n > nums[i - 2]) nums[i++] = n
        return i
    }
}