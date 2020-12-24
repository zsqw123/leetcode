fun main() {
    fun plusOne(digits: IntArray): IntArray {
        var bool = false // 进位则true
        val lastIndex = digits.lastIndex
        if (digits[lastIndex] < 9) {
            digits[lastIndex] = digits[lastIndex] + 1
        } else {
            bool = true
            for (i in lastIndex downTo 0) {
                if (!bool) break
                if (digits[i] == 9) {
                    digits[i] = 0
                } else {
                    digits[i] = digits[i] + 1
                    bool = false
                }
            }
        }

        if (!bool) return digits
        val result = IntArray(lastIndex + 2)
        result[0] = 1
        for (i in 0..lastIndex) {
            result[i + 1] = digits[i]
        }
        return result
    }


    val input = intArrayOf(1, 2, 3)
    plusOne(input).forEach {
        print(it)
    }
}