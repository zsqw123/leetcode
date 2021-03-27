fun main() {
    fun numDistinct(s: String, t: String): Int {
        val array = Array(s.length + 1) { IntArray(t.length + 1) }
        for (i in 0..s.length) array[i][0] = 1
        for (i in 1..s.length) {
            for (j in 1..t.length) {
                if (j > i) break
                if (s[i - 1] == t[j - 1]) { // 如果最后一位相等
                    // s 用最后一位的 a, 那么 t 也用, 于是等于前面一位的
                    // s 不用, 于是等于之前的
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j]
                } else {
                    array[i][j] = array[i - 1][j]
                }
            }
        }
        return array[s.length - 1][t.length - 1]
    }
}