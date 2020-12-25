fun main() {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        override fun toString(): String {
            return `val`.toString() + next.toString()
        }
    }

    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null
        val set = hashSetOf<ListNode>()
        var newHead = head
        while (newHead!!.next != null) {
            if (set.contains(newHead)) return newHead
            set.add(newHead)
            newHead = newHead.next
            if (newHead!!.next == null) return null
        }
        return null
    }

    fun detectCycle1(head: ListNode?): ListNode? {
        if (head?.next == null) return null
        var slow = head.next
        var fast = head.next!!.next
        if (fast == null) return null
        while (fast!!.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next ?: return null
            if (slow == fast) {
                slow = head
                while (slow != fast) {
                    slow = slow!!.next
                    fast = fast!!.next
                }
                return slow
            }
        }
        return null
    }

}