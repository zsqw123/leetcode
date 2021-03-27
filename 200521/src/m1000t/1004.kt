import java.util.*

fun main() {
    fun longestOnes(A: IntArray, K: Int): Int {
        var l = 0
        var r = 0
        val len = A.size
        // 事实上, 我们可以不使用队列, 这样 l 指针移动的可能会较慢(需要再套一层 while 使得 l 指针移到第一个 0 出现的地方的下一位)
        // 但是我看各种题解好像都不使用队列.... emmm
        val zeroPosQue = LinkedList<Int>()
        var max = 0
        while (r < len) {
            if (A[r] == 0) {
                zeroPosQue.addLast(r)
                if (zeroPosQue.size > K) {
                    if (A[l] == 0) {
                        zeroPosQue.removeFirst()
                        l++
                    } else {
                        l = zeroPosQue.removeFirst() + 1
                    }
                }
            }
            r++
            max = maxOf(max, r - l)
        }
        return max
    }

    val array = intArrayOf(1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1)
    println(longestOnes(array, 8))
}