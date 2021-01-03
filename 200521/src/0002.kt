import utils.ListNode

fun main() {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var tmp = 0
        val firstNode = ListNode(0)
        var resultNode = firstNode

        var newL1 = l1
        var newL2 = l2
        while (true) {
            var res = tmp
            if (newL1 != null) res += newL1.`val`
            if (newL2 != null) res += newL2.`val`
            resultNode.next = ListNode(res % 10)
            tmp = res / 10
            resultNode = resultNode.next!!
            if (tmp == 0 && newL1?.next == null && newL2?.next == null) return firstNode.next
            else {
                newL1 = newL1?.next
                newL2 = newL2?.next
            }
        }
    }

    val t00 = ListNode(9)
    t00.next = ListNode(9)
    t00.next!!.next = ListNode(9)
    val t01 = ListNode(9)
    t01.next = ListNode(9)
    println(addTwoNumbers(t00, t01))
}