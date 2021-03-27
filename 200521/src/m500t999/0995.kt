import java.util.*

fun main() {
    fun minKBitFlips(A: IntArray, K: Int): Int {
        val len = A.size
        if (len == K) {
            if (A[0] == 0) {
                for (a in A) if (a == 1) return -1
                return 1
            } else {
                for (a in A) if (a == 0) return -1
                return 0
            }
        }
        var count = 0
        if (K == 1) {
            for (a in A) if (a == 0) count++
            return count
        }
        val queue = LinkedList<Int>() // 翻转队列
        for (i in 0 until len) {
            if (queue.isNotEmpty() && i > queue.peek() + K - 1) queue.removeFirst()
            // 1. 遇到 1 不需要翻转, 遇到 0 才需要
            // 2. 翻转队列长度为偶数时不需要翻转, 奇数时才需要
            // 3. 翻转之前的数据没影响
            //
            // 队列长度偶数时
            //      如果此时下一位是 0 那么需要翻转, 插入翻转队列
            //      如果下一位是 1, 那么不需要翻转
            if (queue.size % 2 == A[i]) {
                if (i + K > len) return -1
                queue.addLast(i)
                count++
            }
        }
        return count
    }

    fun minKBitFlips2(A: IntArray, K: Int): Int {
        var count = 0
        val len = A.size
        val hint = IntArray(len + 1)
        var flip = 0
        for (i in 0 until len) {
            flip = flip xor hint[i]
            if (A[i] xor flip == 1) continue
            if (i + K >= len + 1) return -1
            count++
            flip = flip xor 1
            hint[i + K] = hint[i + K] xor 1
        }
        return count
    }

    val array = intArrayOf(0, 0, 0, 1, 0, 1, 1, 0)
    val start = System.currentTimeMillis()
    println(minKBitFlips2(array, 3))
    println(System.currentTimeMillis() - start)
}