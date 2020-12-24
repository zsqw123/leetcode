fun main() {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        override fun toString(): String {
            return `val`.toString() + next.toString()
        }
    }

    /**
     * 我的做法....
     * @param l1 ListNode?
     * @param l2 ListNode?
     * @return ListNode?
     */
    fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        val pre = ListNode(0)
        var cur = if (l1.`val` > l2.`val`) l2 else l1
        pre.next = cur
        var tmp = if (l1.`val` > l2.`val`) l1 else l2
        while (true) {
            if (cur.next == null) {
                cur.next = tmp
                break
            }
            if (cur.next!!.`val` > tmp.`val`) {
                val next = cur.next!!
                cur.next = tmp
                tmp = next
            } else {
                cur = cur.next!!
            }
        }
        return pre.next
    }

    /**
     * 借鉴到大佬的做法...
     * @param l1 ListNode?
     * @param l2 ListNode?
     * @return ListNode?
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        return when {
            l1 == null -> l2
            l2 == null -> l1
            l1.`val` > l2.`val` -> {
                l2.next = mergeTwoLists(l2.next, l1)
                l2
            }
            else -> {
                l1.next = mergeTwoLists(l1.next, l2)
                l1
            }
        }
    }
}