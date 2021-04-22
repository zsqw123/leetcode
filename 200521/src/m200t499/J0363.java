package m200t499;

public class J0363 {
    static class Solution {
        // 二位前缀和
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int maxY=matrix.length;
            int maxX=matrix[0].length;
            int max=-10001;
            for(int i=1;i<maxX;i++) matrix[0][i]+=matrix[0][i-1];
            for(int i=1;i<maxY;i++) matrix[i][0]+=matrix[i-1][0];
            for(int i=1;i<maxY;i++) for(int j=1;j<maxX;j++)
                matrix[i][j]+=matrix[i-1][j]+matrix[i][j-1]-matrix[i-1][j-1];
            for(int o=0;o<maxY;o++) for(int l=0;l<maxX;l++){
                int now=matrix[o][l]; if(now>k)continue;
                max=Math.max(max,now);
            }
            for(int j=0;j<maxX;j++) for(int o=0;o<maxY;o++) for(int l=j+1;l<maxX;l++){
                int now=matrix[o][l]-matrix[o][j]; if(now>k)continue;
                max=Math.max(max,now);
            }
            for(int i=0;i<maxY;i++) for(int o=i+1;o<maxY;o++) for(int l=0;l<maxX;l++){
                int now=matrix[o][l]-matrix[i][l]; if(now>k)continue;
                max=Math.max(max,now);
            }
            for(int i=0;i<maxY;i++) for(int j=0;j<maxX;j++)
                for(int o=i+1;o<maxY;o++) for(int l=j+1;l<maxX;l++){
                    int now=matrix[o][l]+matrix[i][j]-matrix[i][l]-matrix[o][j];if(now>k)continue;
                    max=Math.max(max,now);
                }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] l1=new int[]{5,-4,-3,4};
        int[] l2=new int[]{-3,-4,4,5};
        int[] l3=new int[]{5,1,5,-4};

        System.out.println(s.maxSumSubmatrix(new int[][]{l1,l2,l3}, -2));
    }
}
