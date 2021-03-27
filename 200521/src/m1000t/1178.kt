fun main() {
//    谜底 word 中包含谜面 puzzle 的第一个字母。
//    谜底 word 中的每一个字母都可以在谜面 puzzle 中找到。
//    例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。

    fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {
        val res = arrayListOf<Int>()
        val map = hashMapOf<Int, Int>()
        for (word in words) {
            var bin = 0
            for (i in word) bin = bin or (1 shl (i - 'a')) // 对应字母位置置 1
            if (Integer.bitCount(bin) <= 7) map[bin] = map.getOrDefault(bin, 0) + 1// 否则不满足都可以找到
        }
        for (puzzle in puzzles) {
            var bin1 = 0
            for (i in 1..6)
                bin1 = bin1 or (1 shl (puzzle[i] - 'a'))
            val bin0 = 1 shl (puzzle[0] - 'a')
            var count = 0
            var last = bin1
            while (last != 0) {
                val key = bin0 or last
                if (map.containsKey(key)) count += map[key]!!
                last = (last - 1) and bin1 // 逐次减 1, 并屏蔽无关位, 即可遍历 bin1 的全部情况
            }
            if (map.containsKey(bin0)) count += map[bin0]!!
            res.add(count)
        }
        return res
    }

    val words = arrayOf("apple", "pleas", "please")
    val puzzles = arrayOf("aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy")
    findNumOfValidWords(words, puzzles)
}