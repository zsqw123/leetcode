package jz;

public class S10_1 {
    /**
     * 超时
     */
    int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }

    /**
     * dp
     */
    int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        return dp[n];
    }

    /**
     * 空间复杂度 O(1)
     */
    int fib3(int n) {
        if (n == 0 || n == 1)
            return n;

        int a = 1, b = 0;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a %= 1000000007;
        }
        return a;
    }
}
