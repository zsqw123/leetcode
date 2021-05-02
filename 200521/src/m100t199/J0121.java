package m100t199;

public class J0121 {
    public int maxProfit(int[] prices) {
        int[] dp=new int[prices.length];
        int min=prices[0];
        dp[0]=0;

        for(int i=1;i<prices.length;i++){
            dp[i]=Math.max(dp[i-1],prices[i]-min);
            min=Math.min(min,prices[i]);
        }

        return dp[prices.length-1];
    }
}
