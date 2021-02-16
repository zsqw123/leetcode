fun main() {
    fun lengthOfLongestSubstring(s: String): Int {
        var res = 0
        val l = s.length
        val fakeMap = IntArray(128)
        var left = 0
        var right = 0
        while (right < l) {
            val index = s[right].toInt()
            // fakeMap[index] 等价于
            // if !containsKey(right) return 0
            // else 左指针移动到最后一次出现该字母的位置
            left = left.coerceAtLeast(fakeMap[index])
            res = res.coerceAtLeast(right - left + 1)
            fakeMap[index] = right + 1
            right++
        }
        return res
    }
}