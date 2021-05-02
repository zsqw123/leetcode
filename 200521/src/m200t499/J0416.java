package m200t499;

public class J0416 {
    // 58ms
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i:nums) total+=i;
        if((total & 1)==1) return false;
        total=total>>1;

        int n=nums.length;
        // dp 表示用前 i 个数组成 j, 是否可以
        boolean[][] dp=new boolean[n+1][total+1];

        for(int i=0;i<=n;i++) for(int j=0;j<=total;j++){
            // 初始状态
            if(i==0 && j==0) dp[i][j]=true; // 0 个数组成 0 一定为 true
            else if(i==0) dp[i][j]=false; // 0 个数组成 非0 一定为 false
            else if(j==0) dp[i][j]=true; // 多个非0数组成 0 一定为 true
            // 事实上 nums 是降一位比较的, 看看前一位能不能组成 j, 再看看前一位能不能组成 j-nums[i-1]
            else if(j>=nums[i-1]) dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
            else dp[i][j]=dp[i-1][j];
        }
        return dp[n][total]; // 返回最后一项即可
    }

    // 36ms 就是对上面的优化
    public boolean canPartition2(int[] nums) {
        int total=0;
        for(int i:nums) total+=i;
        if((total & 1)==1) return false;
        total=total>>1;

        int n=nums.length;
        boolean[][] dp=new boolean[n+1][total+1];
        for(int i=0;i<=n;i++) dp[i][0]=true;
        for(int i=1;i<=n;i++) for(int j=0;j<=total;j++){
            if(j>=nums[i-1]) dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
            else dp[i][j]=dp[i-1][j];
            if(dp[i][total]) return true; // 提前跳出
        }
        return dp[n][total];
    }

    // 24ms 一维化数组
    public boolean canPartition3(int[] nums) {
        int total=0;
        for(int i:nums) total+=i;
        if((total & 1)==1) return false;
        total=total>>1;

        int n=nums.length;
        boolean[] dp=new boolean[total+1];
        dp[0]=true;
        for(int i=1;i<=n;i++) for(int j=total;j>=0;j--){
            // 因为每一次我们都只用到了上一行的数据
            // 因此我们完全没必要保存多行, 一维数组即可
            // 但是这里需要逆向查找, 因为我们要使用到上一个数组 j-nums[i-1] 位置的数据
            // 正向查找就会覆盖之前的数据
            if(j>=nums[i-1]) dp[j]=dp[j]||dp[j-nums[i-1]];
            if(dp[total]) return true;
        }
        return dp[total];
    }
}
