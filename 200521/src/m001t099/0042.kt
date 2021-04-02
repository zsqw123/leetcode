package m001t099

import java.util.*

fun main() {
    fun trap(height: IntArray): Int {
        if (height.size < 3) return 0
        var res = 0
        val stack = Stack<Int>() // 单调减栈
        for (i in height.indices) {
            while (stack.isNotEmpty() && height[stack.peek()] < height[i]) {
                val tmp = stack.pop()
                if (stack.isNotEmpty()) {
                    // 单调减栈, 当前值与栈顶第二个元素比较, 根据木桶效应选择较小的再减去刚 pop 掉的(木桶底板)
                    res += (height[i].coerceAtMost(height[stack.peek()]) - height[tmp]) *
                        (i - stack.peek() - 1) // 再乘长度
                }
            }
            stack.push(i)
        }
        return res
    }
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}