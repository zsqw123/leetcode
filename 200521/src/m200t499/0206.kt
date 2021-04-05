package m200t499

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

    fun reverseList2(head: ListNode?): ListNode? {
        var pre = head ?: return null
        var now = pre.next
        head.next = null
        while (now != null) {
            val tmp = now.next
            now.next = pre
            if (tmp != null) {
                pre = now
                now = tmp
            } else {
                return now
            }
        }
        return pre
    }
}