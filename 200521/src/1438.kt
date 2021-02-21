fun main() {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxQueue = java.util.ArrayDeque<Int>()
        val minQueue = java.util.ArrayDeque<Int>()
        var l = 0
        var r = 0
        var res = 0
        while (r < nums.size) {
            while (!maxQueue.isEmpty() && nums[r] > maxQueue.peekLast())
                maxQueue.removeLast()
            while (!minQueue.isEmpty() && nums[r] < minQueue.peekLast())
                minQueue.removeLast()
            maxQueue.add(nums[r])
            minQueue.add(nums[r])
            r++
            while (maxQueue.peek() - minQueue.peek() > limit) {
                if (maxQueue.peek() == nums[l]) maxQueue.remove()
                if (minQueue.peek() == nums[l]) minQueue.remove()
                l += 1
            }
            res = maxOf(res, r - l)
        }
        return res
    }
}