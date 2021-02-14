fun main() {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val list=(1..nums.size).toMutableList()
        val hashSet = hashSetOf<Int>()
        for (i in 1..nums.size)
            hashSet.add(i)
        for (i in nums)
            hashSet.remove(i)
        return hashSet.toList()
    }
}