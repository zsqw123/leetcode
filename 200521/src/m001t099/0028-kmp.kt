package m001t099

fun main() {
    val start = System.currentTimeMillis()

    // KMP
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (haystack.isEmpty()) return -1
        var cur = 0
        val hLen = haystack.length
        val nLen = needle.length
        if (hLen < nLen) return -1
        if (needle.length == 1) {
            for (i in haystack.indices) {
                if (haystack[i] == needle[0]) return i
            }
            return -1
        }

        /**
         * next数组,next数组每一项为前一项的使得前后缀相等的"最大前后缀长度",其中 next[0] = -1
         *
         * 如:     a b a a b c a c
         * next[] -1 0 0 1 1 2 0 1
         */
        val nextList = IntArray(nLen) { 0 }
        nextList[0] = -1 //第一位肯定是-1
        nextList[1] = 0 //第二位肯定是0
        var j = 1 //遍历next数组用
        var k = 0 //next[j]=k  k就是next数组中的值

        while (j < nLen - 1) {
            when {
                k == -1 -> {        //回溯到0都不匹配,则next值为0
                    j++
                    k = 0
                    nextList[j] = 0
                }
                needle[j] == needle[k] -> {     //找到了匹配的,对应next值+1
                    j++
                    k++
                    nextList[j] = k
                }
                else -> {                    //不匹配,指针回溯
                    k = nextList[k]
                }
            }
        }

        var startIndex = 0
        tailrec fun find(): Int {
            if (cur + nLen > hLen) return -1
            for (i in startIndex until nLen) {
                if (haystack[cur + i] != needle[i]) {
                    startIndex = nextList[i]
                    cur += i - startIndex
                    if (startIndex == -1) startIndex = 0
                    return find()
                }
            }
            return cur
        }
        return find()
    }

    val haystack = "bajsbdwdbawjbdsjadawduhauhdwunsuessueswdawdsadaduhwuidhwiuahdwhduwhudiqioopjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhdsadjwanduihsuessuesiwhduijasdjanwndwudhaiwuijsbduasuessueswdusuessuesswhduwhudiqioopjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhpjdfhryrybfbxcneyeuuhdsadjwanduihiwhduijasdjanwndwudhaiwuijsbduawdusuessuessuesdawwidwnasuessuesndawbdwu"
    val needle = "suessuessues"

    println(strStr(haystack, needle))
    println(System.currentTimeMillis() - start)
}