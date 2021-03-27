fun main() {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val size = nums.size
        if (size < 3) return emptyList()
        val output = arrayListOf<List<Int>>()
        nums.sort()
        for (index1 in 0 until size - 2) {
            val first = nums[index1]
            if (index1 != 0 && (first > 0 || nums[index1 - 1] == nums[index1])) continue
            var left = index1 + 1
            var right = size - 1
            while (left < right) {
                val now = nums[left] + nums[right] + first
                when {
                    now == 0 -> {
                        output.add(listOf(first, nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (left < right && nums[right] == nums[right - 1]) right--
                        left++
                        right--
                    }
                    now > 0 -> {
                        right--
                    }
                    now < 0 -> {
                        left++
                    }
                }
            }
        }
        return output
    }

    val input = intArrayOf(-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4)
    threeSum(input).forEach {
        it.forEach { v -> print("$v,") }
        println()
    }
}