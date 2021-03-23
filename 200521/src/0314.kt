import java.util.*

fun main() {
    class NestedIterator0(nestedList: List<NestedInteger>) {
        inner class MyNode(var value: Int? = null, var next: MyNode? = null)

        private var head = MyNode()
        private var nowNode = head
        fun getAllInt(list: List<NestedInteger>?) {
            if (list == null) return
            for (i in list) if (i.isInteger()) {
                nowNode.next = MyNode(i.getInteger())
                nowNode = head.next!!
            } else getAllInt(i.getList())
        }

        init {
            getAllInt(nestedList)
        }

        private var iteratorNode = head
        fun next(): Int {
            val node = iteratorNode.next!!.value!!
            iteratorNode = iteratorNode.next!!
            return node
        }

        fun hasNext(): Boolean = nowNode.next?.value != null
    }

    class NestedIterator(nestedList: List<NestedInteger>) {
        private val totalQueue: Deque<Int> = ArrayDeque()
        fun getAllInt(list: List<NestedInteger>?) {
            if (list == null) return
            for (i in list) {
                if (i.isInteger()) totalQueue.addLast(i.getInteger())
                else getAllInt(i.getList())
            }
        }

        init {
            getAllInt(nestedList)
        }

        val iterator = totalQueue.iterator()
        fun next(): Int = iterator.next()
        fun hasNext(): Boolean = iterator.hasNext()
    }
}

interface NestedInteger {
    // Constructor initializes an empty nested list.
//          constructor()

    // Constructor initializes a single integer.
//          constructor(value: Int)

    //    @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}

