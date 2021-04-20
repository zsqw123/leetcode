package m001t099;

import java.util.Arrays;

public class J0045 {
    // 暴力算法 超时
    class S0 {
        int min=Integer.MAX_VALUE;
        void way(int[] nums,int index,int count){
            if(count>=min) return; // 剪枝
            if(index>=nums.length-1){
                min=count;
                return;
            }
            for(int i=nums[index];i>0;i--) way(nums,i+index,count+1);
        }
        public int jump(int[] nums) {
            way(nums,0,0);
            return min;
        }
    }

    // 优化暴力 40ms 5%....
    class S1 {
        int min=Integer.MAX_VALUE;
        int[] ways;
        void way(int[] nums,int index,int count){
            if(count>=min) return;
            if(index>=nums.length-1){
                min=count;
                return;
            }
            if(ways[index]<count) return;
            ways[index]=count;
            for(int i=nums[index];i>0;i--) way(nums,i+index,count+1);
        }
        public int jump(int[] nums) {
            ways=new int[nums.length];
            Arrays.fill(ways,Integer.MAX_VALUE);
            way(nums,0,0);
            return min;
        }
    }

    // 依旧是很暴力的算法 这都能 0ms...???
    // 复杂度看脸 最高 n^2 最低 n
    class Solution {
        public int jump(int[] nums) {
            int len=nums.length;
            int[] ways=new int[len];
            Arrays.fill(ways,Integer.MAX_VALUE);
            ways[0]=0;
            for(int i=0;i<len;i++)
                for(int j=i;j<=i+nums[i] && j<len;j++)
                    ways[j]=Math.min(ways[j],ways[i]+1);
            return ways[len-1];
        }
    }
}
