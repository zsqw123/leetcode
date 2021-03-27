package daily

// 实现 36 进制加法
fun main() {
    fun Char.getInt(): Int =
        if (this <='9') this - '0'
        else this - 'a' + 10

    fun Int.getChar(): Int =
        if (this <= 9) this + '0'.toInt()
        else this - 10 + 'a'.toInt()

    fun String.xPlus(other: String): String {
        var c = 0
        val res = StringBuilder()
        var i = length - 1
        var j = other.length - 1
        while (i >= 0 || j >= 0 || c > 0) {
            val x = if (i >= 0) get(i).getInt() else 0
            val y = if (j >= 0) other[j].getInt() else 0
            val tmp = x + y + c
            res.append((tmp % 36).getChar().toChar())
            c = tmp / 36
            i--
            j--
        }
        return res.reversed().toString()
    }

    // 36+10 72+10 = 128 =3k
    println("1a".xPlus("2a"))
}