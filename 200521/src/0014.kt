fun main() {
    val input = arrayOf("c", "acc", "ccc")
    println(longestCommonPrefix(input))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var max = strs[0]
    for (i in 1 until strs.size) {
        if (max.length > strs[i].length) {
            max = strs[i]
        }
    }
    while (max.isNotEmpty()) {
        var breakFlag = false
        for (i in strs.indices) {
            if (strs[i].indexOf(max) != 0) {
                max = max.substring(0, max.length - 1)
                breakFlag = true
                break
            }
        }
        if (!breakFlag) return max
    }
    return max
}