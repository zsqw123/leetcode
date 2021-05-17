package m100t199;

public class J0162 {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int l=0,r=nums.length-1,mid;
        if(nums[0]>nums[1]) return 0;
        if(nums[r]>nums[r-1]) return r;

        while(l+1!=r){
            mid=l+((r-l)>>1);
            if(nums[mid]>nums[mid-1]){
                if(nums[mid]>nums[mid+1]) return mid;
                else l=mid;
            }else r=mid;
        }
        return l;
    }
}
