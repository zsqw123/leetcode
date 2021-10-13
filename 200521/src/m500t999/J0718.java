package m500t999;

public class J0718 {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++)
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
                max = Math.max(max, dp[0][j]);
            }
        for (int i = 1; i < m; i++) {
            if (nums1[i] == nums2[0]) dp[i][0] = 1;
            for (int j = 1; j < n; j++)
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
        }
        return max;
    }
}

