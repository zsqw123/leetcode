package m500t999;

public class J0518 {
    public int change(int amount, int[] coins) {
        int len=coins.length;
        if(amount==0 && len==0) return 1;
        if(amount==0) return 1;
        if(len==0) return 0;

        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin:coins) for(int j=coin;j<=amount;j++)
            dp[j]+=dp[j-coin];
        return dp[amount];
    }
}
