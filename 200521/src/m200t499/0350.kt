fun main() {
    fun HashMap<Int, Int>.process(value: Int, addTo: ArrayList<Int>) {
        if (!containsKey(value)) return
        this[value] = this[value]!! - 1
        addTo.add(value)
        if (this[value] == 0) remove(value)
    }

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val result = arrayListOf<Int>()
        val times1 = hashMapOf<Int, Int>()

        nums1.forEach {
            times1[it] = (times1[it] ?: 0) + 1
        }
        nums2.forEach {
            times1.process(it, result)
        }
        return result.toIntArray()
    }


    val num1 = intArrayOf(4, 9, 5)
    val num2 = intArrayOf(9, 4, 9, 8, 4)
    var result = ""
    intersect(num1, num2).forEach { result += it.toString() }
    println(result)
}

