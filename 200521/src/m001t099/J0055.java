package m001t099;

public class J0055 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int rightmost=0;
        for (int i=0;i<n;++i) if(i<=rightmost){
            rightmost=Math.max(rightmost, i+nums[i]);
            if(rightmost>=n-1)return true;
        }
        switch (n){
            case 1: n=1;return false;
            case 2: n=2;
        }
        return false;
    }
}
