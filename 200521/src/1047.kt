import java.lang.StringBuilder
import java.util.*

fun main() {
    fun removeDuplicates(S: String): String {
        val s = ArrayDeque<Char>()
        for (c in S) if (s.peekFirst() == c) {
            do {
                s.removeFirst()
            } while (s.peekFirst() == c)
        } else s.addFirst(c)
        val res = StringBuilder()
        while (s.isNotEmpty()) res.append(s.pollLast())
        return res.toString()
    }
}