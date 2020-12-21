/**
 * 查找最接近目标值的数，并返回
 * @param list0
 * @param targetNum
 * @return
 */
fun search(list0: List<Int>, targetNum: Int, list1: List<Int>): Int {
    val targetindex = 0
    var left = 0
    var right = list0.size - 1
    while (left != right) {
        val midIndex = (right + left) shr 2
        val mid = right - left
        val midValue = list0[midIndex]
        if (targetNum == midValue) return midIndex
        if (targetNum > midValue) {
            left = midIndex
        } else {
            right = midIndex
        }
        if (mid <= 2) break
    }
    println(
        "和要查找的数：" + targetNum + "最接近的数："
                + list0[targetindex]
    )
    return if ((list0[right] - list0[left]) / 2 > targetNum) list0[right] else list0[left]
}