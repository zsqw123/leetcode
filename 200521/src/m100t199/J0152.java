package m100t199;

public class J0152 {
    // 3ms
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        else if(n==1) return nums[0];
        int min=nums[0];
        int max=min;
        int res=max;
        for(int i=1;i<n;i++){
            int m=max;
            int now=nums[i];
            // 如果当前负的, 那么最大的数可能变成最小的, 最小也可能变成最大的
            max=Math.max(Math.max(max*now,now),min*now);
            min=Math.min(Math.min(min*now,now),m*now);
            res=Math.max(res,max);
        }
        return res;
    }

    // 0ms az
    public int maxProduct2(int[] nums) {
        int t=1;
        int res=Integer.MIN_VALUE;
        for(int i:nums){
            t*=i;
            res=Math.max(t,res);
            if(i==0) t=1;
        }
        t=1;
        for(int i=nums.length-1;i>-1;i--){
            t*=nums[i];
            res=Math.max(t,res);
            if(t==0) t=1;
        }
        return res;
    }
}
