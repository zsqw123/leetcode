package m001t099;

public class J0075 {
    public void sortColors(int[] nums) {
        int i0=0,i1=0,i2=0;
        for(int i:nums)switch(i){
            case 0:nums[i2++]=2;nums[i1++]=1;nums[i0++]=0;break;
            case 1:nums[i2++]=2;nums[i1++]=1;break;
            case 2:nums[i2++]=2;break;
        }
    }

    public static void main(String[] args) {
        J0075 j=new J0075();
        int[] ints=new int[]{2,0,2,1,1,0};
        j.sortColors(ints);
        for (int anInt : ints) System.out.print(anInt);
    }
}
