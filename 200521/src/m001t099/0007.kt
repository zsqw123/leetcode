package m001t099

fun main() {
    fun reverse(x: Int): Int {
        var out = 0L
        var xx = x
        while (xx != 0) {
            out = out * 10 + xx % 10
            xx /= 10
        }
        return if (out.toInt().toLong() != out) 0 else out.toInt()
    }
}