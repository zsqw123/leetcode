fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    array.forEach { print(it) }
    println()
    rotate3(array, 10)
    array.forEach { print(it) }
}

fun rotate(nums: IntArray, k: Int): Unit {
    val tmp = arrayListOf<Int>()
    for (i in nums.size - k % nums.size until nums.size) {
        tmp.add(nums[i])
    }
    for (i in 0 until nums.size - k % nums.size) {
        tmp.add(nums[i])
    }
    tmp.forEachIndexed { i, v -> nums[i] = v }
}

/**
 * solution 2
 */
fun rotate2(nums: IntArray, k: Int): Unit {
    val list = arrayListOf<Int>()
    list.addAll(nums.takeLast(k % nums.size))
    list.addAll(nums.toList())
    for (i in nums.indices) {
        nums[i] = list[i]
    }
}

/**
 * solution 3
 */
fun rotate3(nums: IntArray, k: Int): Unit {
    val size = nums.size
    val ints = arrayOfNulls<Int>(size)
    val kk = k % size
    for (intIndex in 0 until kk) {
        ints[intIndex] = nums[intIndex + size - kk]
    }
    for (intIndex in 0 until size - kk) {
        ints[intIndex + kk] = nums[intIndex]
    }
    for (i in nums.indices) {
        nums[i] = ints[i]!!
    }
}

