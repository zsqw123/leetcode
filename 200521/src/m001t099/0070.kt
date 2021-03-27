fun main() {
    /**
     * 刚开始尝试的莽递归...结果时间必然超出限制
     */
    var ways = 0
    fun doClimb(remain: Int, step: Int = 0) {
        val next = remain - step
        if (next < 0) return
        if (next == 0) {
            ways++
            return
        }
        doClimb(next, 1)
        doClimb(next, 2)
    }

    /**
     * 因为爬楼梯只能由前一个或者当前楼梯爬到下一个
     * 所以下一级楼梯的次数由前两级相加得到
     * @param times Int
     * @param before1 Int
     * @param now Int
     */
    tailrec fun doClimb1(times: Int, before1: Int, now: Int) {
        if (times == 0) {
            ways = now
            return
        }
        doClimb1(times - 1, now, before1 + now)
    }

    fun climbStairs(n: Int): Int {
        //瞎递归的做法
//        doClimb(n, 1)
//        doClimb(n, 2)
        if (n == 1) return 1
        doClimb1(n - 2, 1, 2)
        return ways
    }

    val start = System.nanoTime()
    println(climbStairs(47))
    println(System.nanoTime() - start)
}