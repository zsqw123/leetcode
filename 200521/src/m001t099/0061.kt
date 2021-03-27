package m001t099

import utils.ListNode

fun main() {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) return head
        var len = 1
        var temp = head
        while (temp!!.next != null) {
            len++
            temp = temp.next
        }

        temp.next = head
        val newK = k % len
        var index = len - newK //找到要断开循环链表的节点纪录链表新的头结点
        while (index-- > 0) {
            temp = temp!!.next
        }
        val newHead = temp!!.next
        temp.next = null
        return newHead
    }
}