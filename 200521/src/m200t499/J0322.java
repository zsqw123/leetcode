package m200t499;

import java.util.Arrays;

public class J0322 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int len=coins.length;
        if(len==0) return -1;

        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=len;i++) for(int j=coins[i-1];j<=amount;j++)
            if(j-coins[i-1]!=amount+1)
                dp[j]=Math.min(dp[j],dp[j-coins[i-1]]+1);
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
