import utils.ListNode

fun main() {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        val zero = ListNode(0)
        zero.next = head
        var nowNode = zero
        var targetNode: ListNode? = null
        var i = 0
        while (true) {
            if (i == n) targetNode = zero
            if (nowNode.next == null) {
                targetNode!!.next = targetNode.next!!.next
                return zero.next
            } else {
                targetNode = targetNode?.next
                nowNode = nowNode.next!!
            }
            i++
        }
    }
}