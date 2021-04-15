package m001t099;

import java.util.Arrays;

public class J0031 {
    void change(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        if(len==1) return;
        if(len==2){
            change(nums,0,1);
            return;
        }
        for(int i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){ // 找到了比上一个小的
                for(int j=i+2;j<len;j++)
                    if(nums[j]<=nums[i]) { // 在之后查找比 nums[i] 的还小的(或者相等)
                        change(nums,i,j-1); // 找到就交换上一个和 nums[i]
                        Arrays.sort(nums,i+1,len); // 排序的目的是使得后面是最小的
                        return;
                    }
                change(nums,i,len-1); // 实在没有, 就用最后一项凑合
                Arrays.sort(nums,i+1,len);
                return;
            }
        }
        for(int i=0;i<len/2;i++) change(nums,i,len-1-i); // 数组是降序的, 将其升序化
    }
}
