package m001t099

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        if (nums.isEmpty()) return result
        nums.sort()
        // 路径
        val track = ArrayDeque<Int>()
        fun backtrack(from: Int) {
            if (from > nums.size) return
            result.add(ArrayList(track))

            for (index in from until nums.size) {
                // 剪枝
                if (index > from && nums[index] == nums[index - 1])
                    continue
                // 选择
                track.push(nums[index])
                // 递归
                backtrack(index + 1)
                // 回溯
                track.pop()
            }
        }
        backtrack(0)
        return result
    }

    class CopyClass : Cloneable {
        var i = 0
        public override fun clone(): Any {
            return super.clone()
        }
    }

    val a = CopyClass()
    a.i = 1
    val b = a
    val c = a.clone() as CopyClass
    c.i = 2
    listOf(a, b, c).forEach { println(it) }
    println(a.i)
}