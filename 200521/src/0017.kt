fun main() {
    val keymap = hashMapOf(
        '2' to hashSetOf('a', 'b', 'c'),
        '3' to hashSetOf('d', 'e', 'f'),
        '4' to hashSetOf('g', 'h', 'i'),
        '5' to hashSetOf('j', 'k', 'l'),
        '6' to hashSetOf('m', 'n', 'o'),
        '7' to hashSetOf('p', 'q', 'r', 's'),
        '8' to hashSetOf('t', 'u', 'v'),
        '9' to hashSetOf('w', 'x', 'y', 'z')
    )

    fun toCombine(
        originalList: List<List<Char>>,
        position: Int,
        returnList: HashSet<String>,
        cacheList: ArrayList<Char>
    ) {
        val originalItemList = originalList[position]
        for (i in originalItemList.indices) {
            val childCacheList = if (i == originalItemList.size - 1) cacheList else ArrayList(cacheList)
            childCacheList.add(originalItemList[i])
            if (position == originalList.size - 1) {
                var tmp = ""
                for (str in childCacheList) {
                    tmp += str
                }
                returnList.add(tmp)
                continue
            }
            toCombine(originalList, position + 1, returnList, childCacheList)
        }
    }

    fun getCombine(list: List<List<Char>>): List<String> {
        val returnList = hashSetOf<String>()
        toCombine(list, 0, returnList, ArrayList())
        return returnList.toList()
    }


    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val input = arrayListOf<List<Char>>()
        for (char in digits) input.add(keymap[char]!!.toList())
        return getCombine(input)
    }
}