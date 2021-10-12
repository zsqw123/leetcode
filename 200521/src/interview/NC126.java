package interview;

import java.util.Arrays;

public class NC126 {
    /**
     * 换钱的最少货币数
     *  https://www.nowcoder.com/questionTerminal/3911a20b3f8743058214ceaa099eeb45
     *
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney (int[] arr, int aim) {
        if(aim==0) return 0;
        int len=arr.length;
        if(len==0) return -1;
        int[] dp=new int[aim+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=aim;i++)
            for(int j=0;j<len;j++)
                if(i>=arr[j]){
                    if(dp[i-arr[j]]==Integer.MAX_VALUE) continue;
                    dp[i]=Math.min(dp[i-arr[j]]+1,dp[i]);
                }
        return dp[aim]==Integer.MAX_VALUE?-1:dp[aim];
    }
}
