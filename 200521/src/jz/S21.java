package jz;

public class S21 {
    public int[] exchange(int[] nums) {
        int len=nums.length;
        if(len<2) return nums;
        int j=-1;
        int i=0;
        while(i<len){
            if((nums[i] & 1)==0) {
                if(j==-1) j=i+1;
                while(j<len){
                    if((nums[j] & 1)==1){
                        int t=nums[j];
                        nums[j]=nums[i];
                        nums[i]=t;
                        j++;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
        return nums;
    }

    /**
     * 210729
     */
    public int[] exchange2(int[] nums) {
        int len=nums.length;
        if(len<2) return nums;

        int i=0,j=len-1;
        while(i<j){
            if((nums[i] & 1)==1){
                i++;
                continue;
            }
            while(j>i && (nums[j] & 1)==0){
                j--;
            }
            if(j>i){
                int tmp=nums[j];
                nums[j]=nums[i];
                nums[i]=tmp;
            }
        }

        return nums;
    }
}
