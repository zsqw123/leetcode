package m001t099;

public class J0063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)if(obstacleGrid[i][0]==0)dp[i][0]=1;else break;
        for(int j=0;j<n;j++)if(obstacleGrid[0][j]==0)dp[0][j]=1;else break;
        for(int i=1;i<m;i++)for(int j=1;j<n;j++){
            if(obstacleGrid[i-1][j]==0)dp[i][j]+=dp[i-1][j];
            if(obstacleGrid[i][j-1]==0)dp[i][j]+=dp[i][j-1];
        }
        return dp[m-1][n-1];
    }
}
