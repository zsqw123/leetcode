fun main() {
    fun plusOne(digits: IntArray): IntArray {
        var bool = false // 进位则true
        digits.reverse()
        if (digits[0] < 9) {
            digits[0] = digits[0] + 1
        } else {
            bool = true
            for (i in digits.indices) {
                if (!bool) break
                if (digits[i] == 9) {
                    digits[i] = 0
                } else {
                    digits[i] = digits[i] + 1
                    bool = false
                }
            }
        }

        if (!bool) {
            digits.reverse()
            return digits
        }

        val result = digits.copyOf(digits.size + 1)
        result[result.lastIndex] = 1
        result.reverse()
        return result
    }


    val input = intArrayOf(1, 2, 3)
    plusOne(input).forEach {
        print(it)
    }
}