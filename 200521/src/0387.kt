fun main() {
    fun firstUniqChar(s: String): Int {
        if (s.isEmpty()) return -1
        val r = IntArray(26)
        for (i in s.indices) {
            r[s[i] - 'a']++
        }
        for (i in s.indices) {
            if (r[s[i] - 'a'] == 1) return i
        }
        return -1
    }

    val s = "loveleetcode"
    println(firstUniqChar(s))
}