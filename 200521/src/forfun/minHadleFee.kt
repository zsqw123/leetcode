package forfun

import kotlin.math.*


/**
 * 题目出自我个人博客 https://zsqw123.fun/2021/01/19/%E6%9C%80%E5%B0%8F%E5%9F%BA%E9%87%91%E8%B4%B9%E7%8E%87
 */
fun main() {
    fun Int.round() = (this / 10.0).roundToInt() * 10
    fun Int.floor() = floor(this / 10.0).toInt() * 10

    /**
     * @param targetMoney Int 这里选择 int 的原因, 是因为担心 double 的数据精度.
     * @param feeRate Double 啊这... 这玩意它必须用 double 啊,绝了.
     */
    fun minHadleFee(targetMoney: Int, feeRate: Double): Double {
        val realMoney = (targetMoney * 1000 / (1 + feeRate)).toInt().round() // 扩大1000倍, 计算净值并四舍五入
        val maxFee = targetMoney * 1000 - realMoney + 5 // 尽可能让 fee 最大, 精确值
        var maxMoney = maxFee * (1 + feeRate) / feeRate // money / fee = (1 + rate) / rate, 精确度同 double, 近似认为精确
        if (maxMoney - maxMoney.toInt() == 0.0) maxMoney -= 10 // 如若刚好是 1.05 倍, 那么 - 10.
        return maxMoney.toInt().floor() / 1000.0 // 向下取整输出
    }
    println(minHadleFee(16, 0.0015))
}
