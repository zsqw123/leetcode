fun main() {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || s.length == 1) return s
        val sArray = s.toCharArray()
        val rows = Array(numRows) { StringBuilder() }
        var down = true
        var j = 0
        for (i in sArray) {
            if (j == 0) down = true
            if (j == numRows - 1) down = false
            rows[j].append(i)
            if (down) j++ else j--

        }
        val output = StringBuilder()
        rows.forEach { it.forEach { i -> output.append(i) } }
        return output.toString()
    }

    val s = "LEETCODEISHIRING"
    val numRows = 4
    println(convert(s, numRows))
}