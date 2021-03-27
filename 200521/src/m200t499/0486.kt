fun main() {
    var half = 0
    fun run(array: MutableList<Int>, is1: Boolean = true, tmp1: Int = 0, tmp2: Int = 0): Boolean {
        val start = array[0]
        val end = array[array.size - 1]
        if (array.size == 1) {
            var a = tmp1
            if (is1) a += start
            return tmp1 >= half
        }
        if (tmp1 >= half) return true
        if (tmp2 > half) return false
        val copy: MutableList<Int> = array
        array.removeAt(0)
        copy.removeAt(array.size - 1)
        return if (is1) run(copy, !is1, tmp1 + start, tmp2) || run(array, !is1, tmp1 + end, tmp2)
        else run(copy, !is1, tmp1, tmp2 + start) || run(array, !is1, tmp1, tmp2 + end)
    }

    fun PredictTheWinner(nums: IntArray): Boolean {
        if (nums.size % 2 == 0 || nums.size == 1) return true
        var sum = 0
        nums.forEach { sum += it }
        half = if (sum % 2 == 0) sum / 2 else (sum + 1) / 2
        return run(nums.toMutableList())
    }

    val input = intArrayOf(1, 1, 1)
    println(PredictTheWinner(input))
}

