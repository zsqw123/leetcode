fun main() {
    class Num(var firstPos: Int, var count: Int) // 第一次出现的位置, 出现的次数

    fun findShortestSubArray(nums: IntArray): Int {
        val numHash = hashMapOf<Int, Num>()
        var res = 50000
        var countMax = 0
        nums.forEachIndexed { i, v ->
            val newCount = if (numHash.containsKey(v)) ++numHash[v]!!.count // 存在就 count++
            else 1.apply { numHash[v] = Num(i, 1) } // 不存在就返回 1, 并对当前数初始化
            if (countMax < newCount) { // 如果新 count 比最大的 count大, 毫不犹豫替换 res
                res = i - numHash[v]!!.firstPos + 1
                countMax = newCount
            } else if (countMax == newCount) { // 与原来 count 一致, 判断哪个更小
                res = minOf(res, i - numHash[v]!!.firstPos + 1)
            }
        }
        return res
    }
}