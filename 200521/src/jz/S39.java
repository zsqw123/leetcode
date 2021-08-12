package jz;

public class S39 {
    public int majorityElement(int[] nums) {
        int now=nums[0],count=0;
        for(int i:nums){
            if(i==now) count++;
            else{
                if(count==0){
                    now=i;
                    count=1;
                }
                else count--;
            }
        }
        return now;
    }
}
