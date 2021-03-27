fun main() {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        if (prices.size < 2) return 0
        for (i in 0..prices.size - 2) {
            if (prices[i] < prices[i + 1]) profit += prices[i + 1] - prices[i]
        }
        return profit
    }

    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}
