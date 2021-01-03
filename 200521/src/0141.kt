import utils.ListNode

fun main() {
    /**
     * hashSet
     * @param head ListNode?
     * @return Boolean
     */
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        val set = hashSetOf<ListNode>()
        var newHead = head
        while (newHead!!.next != null) {
            if (set.contains(newHead.next!!)) return true
            set.add(newHead)
            newHead = newHead.next
            if (newHead == null) return false
        }
        return false
    }

    /**
     * 快慢指针
     * @param head ListNode?
     * @return Boolean
     */
    fun hasCycle1(head: ListNode?): Boolean {
        if (head == null) return false
        var slow = head
        var fast = head.next
        if (fast == null) return false
        while (fast!!.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next ?: return false
            if (slow == fast) return true
        }
        return false
    }
}