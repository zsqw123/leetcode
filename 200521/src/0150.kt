import java.util.*

fun main() {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        for (t in tokens) {
            when (t) {
                "+" -> stack.add(stack.pop() + stack.pop())
                "-" -> {
                    val top = stack.pop()
                    stack.add(stack.pop() - top)
                }
                "*" -> stack.add(stack.pop() * stack.pop())
                "/" -> {
                    val top = stack.pop()
                    stack.add(stack.pop() / top)
                }
                else -> stack.add(t.toInt())
            }
        }
        return stack.peek()
    }

    class Node(var v: Int, var next: Node?)

    fun evalRPN2(tokens: Array<String>): Int {
        var node: Node? = null
        for (t in tokens) {
            node = when (t) {
                "+" -> Node(node!!.next!!.v + node.v, node.next!!.next)
                "-" -> Node(node!!.next!!.v - node.v, node.next!!.next)
                "*" -> Node(node!!.next!!.v * node.v, node.next!!.next)
                "/" -> Node(node!!.next!!.v / node.v, node.next!!.next)
                else -> Node(t.toInt(), node)
            }
        }
        return node!!.v
    }

    fun evalRPN3(tokens: Array<String>): Int {
        val arr = IntArray(tokens.size)
        var top = -1
        for (s in tokens) {
            when (s) {
                "+" -> arr[--top] += arr[top + 1]
                "-" -> arr[--top] -= arr[top + 1]
                "*" -> arr[--top] *= arr[top + 1]
                "/" -> arr[--top] /= arr[top + 1]
                else -> arr[++top] = s.toInt()
            }
        }
        return arr[top]
    }
}