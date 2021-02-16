import java.util.*

fun main() {
    val result = ArrayList<List<Int>>()
    fun permute(remain: ArrayList<Int>, single: ArrayList<Int>) {
        for (i in remain.indices) {
            val newSingle = ArrayList(single)
            val newRemain = ArrayList(remain)
            newSingle.add(newRemain[i])
            newRemain.removeAt(i)
            if (newRemain.isEmpty()) result.add(newSingle)
            permute(newRemain, newSingle)
        }
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val remain = ArrayList<Int>()
        for (i in nums) remain.add(i)
        permute(remain, ArrayList())
        return result
    }
}