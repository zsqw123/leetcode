fun main() {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var tmp0 = l1
        var tmp1 = l2
        var pre = ListNode(0)
        var carry = 0
        while (tmp0 != null || tmp1 != null) {
            val x = tmp0?.`val` ?: 0
            val y = tmp1?.`val` ?: 0
            var sum = x + y + carry
            carry = if (sum > 9) 1 else 0
            sum %= 10
            pre.next = ListNode(sum)
            pre = pre.next!!
            tmp0 = tmp0?.next
            tmp1 = tmp1?.next
        }
        if (carry == 1) {
            pre.next = ListNode(carry)
        }
        return pre.next
    }

    val t00 = ListNode(2)
    t00.next = ListNode(4)
    t00.next!!.next = ListNode(3)
    val t01 = ListNode(5)
    t01.next = ListNode(6)
    t01.next!!.next = ListNode(4)
    t01.next!!.next!!.next = ListNode(4)
}