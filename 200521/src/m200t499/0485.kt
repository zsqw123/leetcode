fun main() {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var i = 0
        var j: Int
        while (i < nums.size) {
            if (nums[i] == 1) {
                if (max == 0) max = 1 // 遇到 1 就给 max 初始化
                // 检查加 max 之后是否以 0 结束
                // 如果是, 则说明当前最大 <= max, continue.
                val end = i + max
                if (end < nums.size && nums[end] == 0) {
                    i = end + 1
                    continue
                }
                // 将 j 移到 i 的位置, 逐个检查到 i+max 是否匹配
                j = i
                while (nums[j] == 1) {
                    ++j
                    if (j > nums.size - 1) break
                }
                max = max.coerceAtLeast(j - i)
                // 此时要么 j 已经超范围, 要么 nums[j]=0, 因此移动 i 到 j+1 位置
                i = j + 1
            } else i++
        }
        return max
    }

    val input = intArrayOf(1, 0, 0, 1, 1, 0, 1)
    println(findMaxConsecutiveOnes(input))
}