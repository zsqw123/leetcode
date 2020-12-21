fun main() {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for ((i, t) in nums.withIndex()) {
            val temp = target - t
            if (map.containsKey(temp)) {
                return intArrayOf(map[temp]!!, i)
            }
            map[t] = i
        }
        return intArrayOf()
    }
}