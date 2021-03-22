package daily

fun main() {
    // 一个乱序数组，求出满足条件的数。他比之前所有的数都大，比之后的所有的数都小。
    // 例如，输入{2,1,5,9,8,16,20,30}，输出{5,16,20}
    fun search(input: IntArray): IntArray {
        val maxAttr = input.clone()
        val minAttr = input.clone()
        maxAttr[0] = input[0]
        for (i in 1 until input.size)
            maxAttr[i] = maxAttr[i - 1].coerceAtLeast(maxAttr[i])
        minAttr[input.size - 1] = input.last()
        for (i in input.size - 2 downTo 1)
            minAttr[i] = minAttr[i + 1].coerceAtMost(minAttr[i])
        val res = ArrayList<Int>()
        for (i in 1 until input.size - 1)
            if (input[i] == maxAttr[i] && input[i] == minAttr[i]) res.add(input[i])
        return res.toIntArray()
    }
    search(intArrayOf(2, 1, 5, 9, 8, 16, 20, 30)).forEach { println(it) }
}