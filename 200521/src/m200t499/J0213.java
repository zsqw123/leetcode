package m200t499;

public class J0213 {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0], nums[1]);
        int[] res=new int[len];
        res[0]=nums[0];
        res[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<len-1;i++)
            res[i]=Math.max(res[i-1],res[i-2]+nums[i]);
        res[len-1]=res[len-2];
        res[0]=0;
        res[1]=nums[1];
        for(int i=2;i<len-1;i++)
            res[i]=Math.max(res[i-1],res[i-2]+nums[i]);
        res[len-1]=Math.max(res[len-1],res[len-3]+nums[len-1]);
        return res[len-1];
    }
}
