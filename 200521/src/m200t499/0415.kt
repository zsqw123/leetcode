package m200t499

fun main() {
    fun addStrings(num1: String, num2: String): String {
        var c = 0
        val res = StringBuilder()
        var i = num1.length - 1
        var j = num2.length - 1
        while (i >= 0 || j >= 0 || c > 0) {
            val x = if (i >= 0) num1[i] - '0' else 0
            val y = if (j >= 0) num2[j] - '0' else 0
            val tmp = x + y + c
            res.append(tmp % 10)
            c = tmp / 10
            i--
            j--
        }
        return res.reversed().toString()
    }
}