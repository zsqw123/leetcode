fun main() {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
        var total = 0 // 本来也就不生气的时候赚的
        var extra = 0 // 靠抑制得到的额外收益的最大值
        var tmp = 0 // 抑制时段内的额外收益
        var angerStart = 0 // 开始抑制的索引
        val size = customers.size
        var i = 0
        while (i < size) {
            // 抑制时长达到指定时长, 判断如果开始抑制的时候生气了, 那么减去那时候的客流
            if (i - angerStart == X) {
                if (grumpy[angerStart] == 1)
                    tmp -= customers[angerStart]
                angerStart++
            }
            // 是哪段时间产生的收益就加到哪段去awa
            if (grumpy[i] == 1) {
                tmp += customers[i]
                extra = maxOf(extra, tmp)
            } else total += customers[i]
            i++
        }
        return total + extra
    }
}