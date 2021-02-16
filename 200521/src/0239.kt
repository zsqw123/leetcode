import java.util.*

fun main() {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (k == 1) return nums
        val result = IntArray(nums.size - k + 1)
        val window = LinkedList<Int>()
        window.addLast(nums[0])
        for (i in 1 until nums.size) {
            // 确保窗口按大小排序
            while (i > 0 && window.isNotEmpty() && nums[i] > window.last) {
                window.removeLast()
            }
            window.addLast(nums[i])
            // 此处是判断 nums[0] 是否过时, 过时就删掉
            if (i >= k && nums[i - k] == window.first) window.pollFirst()
            if (i >= k - 1) result[i - k + 1] = window.first
        }
        return result
    }
}