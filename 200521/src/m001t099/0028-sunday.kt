package m001t099

fun main() {
    val start = System.currentTimeMillis()

    // Sunday 但下面这个算法只针对只包含26位小写字母的情况
    // 如果要包含全部字符的话可以考虑一下hashMap吧 只包含字母其实是投机取巧了
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (haystack.isEmpty()) return -1
        var cur = 0
        val hLen = haystack.length
        val nLen = needle.length
        if (hLen < nLen) return -1
        val wordMap = IntArray(26) { -1 }
        for (i in 0 until nLen) wordMap[needle[i] - 'a'] = i // 寻找某字母最后出现的位置

        tailrec fun search(): Int {
            if (cur + nLen > hLen) return -1
            var i = 0
            while (cur + i < hLen && i < nLen) {
                if (haystack[cur + i] != needle[i]) {
                    if (cur + nLen > hLen - 1) return -1
                    val tmpIndex = wordMap[haystack[cur + nLen] - 'a']
                    if (tmpIndex != -1) {
                        cur += nLen - tmpIndex
                        return search()
                    } else {
                        cur += nLen + 1
                        if (cur + nLen > hLen) return -1
                        return search()
                    }
                }
                i++
            }
            return cur
        }
        return search()
    }

    // Sunday 面向异常编程 + 非递归... 搞笑的hhhhhh
    fun strStrTry(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (haystack.isEmpty()) return -1
        var cur = 0
        val hLen = haystack.length
        val nLen = needle.length
        if (hLen < nLen) return -1
        val wordMap = IntArray(26) { -1 }
        for (i in 0 until nLen) wordMap[needle[i] - 'a'] = i // 寻找某字母最后出现的位置

        return try {
            if (cur + nLen > hLen) return -1
            var i = 0
            while (i < nLen) {
                if (haystack[cur + i] != needle[i]) {
                    val tmpIndex = wordMap[haystack[cur + nLen] - 'a']
                    if (tmpIndex != -1) {
                        cur += nLen - tmpIndex
                        if (cur + nLen > hLen) return -1
                        i = 0
                        continue
                    } else {
                        cur += nLen + 1
                        if (cur + nLen > hLen) return -1
                        i = 0
                        continue
                    }
                }
                i++
            }
            cur
        } catch (e: Exception) {
            return -1
        }
    }

    val haystack = "bajsbdwdbawjbdsjadawduhauhdwunsuessueswdawdsadaduhwuidhwiuahdwhduwhudiqioopjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhdsadjwanduihsuessuesiwhduijasdjanwndwudhaiwuijsbduasuessueswdusuessuesswhduwhudiqioopjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhdsadjwanduihiwhduijasdjanwndwudhaiwuijsbduawdusuessuessuesdawwidwnasuessuesndawbdwu"
    val needle = "suessuessues"

    println(strStr(haystack, needle))
    println(System.currentTimeMillis() - start)
}