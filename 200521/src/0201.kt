fun main() {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var tmp = n
        while (m < tmp) {
            tmp = tmp and tmp - 1
        }
        return tmp
    }
    println(rangeBitwiseAnd(5, 7))
}