package m001t099

import java.util.*

fun main() {
    fun largestRectangleArea(heights: IntArray): Int {
        var res = 0
        val stack = ArrayDeque<Int>()
        val newHeights = IntArray(heights.size + 2)
        for (i in 1 until heights.size + 1) newHeights[i] = heights[i - 1]
        for (i in newHeights.indices) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                val cur = stack.pop()
                res = res.coerceAtLeast((i - stack.peek() - 1) * newHeights[cur])
            }
            stack.push(i)
        }
        return res
    }
}