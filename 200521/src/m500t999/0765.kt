fun main() {
    fun minSwapsCouples(row: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (i in row.indices) map[row[i]] = i // 对人和人在的位置映射
        val cpList = row.toMutableList()
        var times = 0
        for (cpi in cpList.indices) {
            if (!map.containsKey(cpList[cpi])) continue // 已经配对, 跳过.
            var tmpi = cpi
            var tmp = cpList[tmpi]
            do {
                map.remove(tmp)
                // 他真正的对象为 p
                val p = if (tmp % 2 == 0) tmp + 1 else tmp - 1
                // 他现在旁边的人是 nowP
                val nowP = if (tmpi % 2 == 0) cpList[tmpi + 1] else cpList[tmpi - 1]
                // 交换 p 和 nowP的位置, 一次交换 times+1
                if (p != nowP) {
                    tmpi = map[p]!!
                    cpList[tmpi] = nowP
                    tmp = nowP
                    times++
                }
                map.remove(p)
            } while (map.containsKey(tmp)) // 不断交换直至恰好最后一次交换时对象在身边
        }
        return times
    }
}