fun main() {
    val result = ArrayList<List<Int>>()
    fun permute(remain: ArrayList<Int>, single: ArrayList<Int>) {
        for (i in remain.indices) {
            // 相比 0046 多了一步剪枝, 和前面的元素相同就没必要再进行一次搜索了
            if (i > 0 && remain[i] == remain[i - 1]) continue
            val newSingle = ArrayList(single)
            val newRemain = ArrayList(remain)
            newSingle.add(newRemain[i])
            newRemain.removeAt(i)
            if (newRemain.isEmpty()) result.add(newSingle)
            permute(newRemain, newSingle)
        }
    }

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        val remain = ArrayList<Int>()
        for (i in nums) remain.add(i)
        permute(remain, ArrayList())
        return result
    }
}