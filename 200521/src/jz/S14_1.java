package jz;

public class S14_1 {
    public int cuttingRope(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int[] dp=new int[n+1];
        // 事实上真正的 123 出现的解并不是 123, 因为 123 再进行分割的话回比原来的数更小, 还不如不分割
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++)
            for(int j=1;j<=i/2;j++)
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
        return dp[n];
    }
}
