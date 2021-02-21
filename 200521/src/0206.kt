import utils.ListNode

fun main() {
    tailrec fun reverse(pre: ListNode?, cur: ListNode?): ListNode? {
        if (cur == null) return pre
        val next = cur.next
        cur.next = pre
        return reverse(cur, next)
    }

    fun reverseList(head: ListNode?): ListNode? {
        return reverse(null, head)
    }
}