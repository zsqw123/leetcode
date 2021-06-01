package m100t199;

import java.util.HashSet;

public class J0128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>((int)(nums.length/0.75),0.75f);
        for(int i:nums) set.add(i);
        int max=0;
        for(int i:nums)
            if(set.remove(i)){
                int cur=i,curMax=1;
                while(set.remove(++cur)) curMax++;
                cur=i;
                while(set.remove(--cur)) curMax++;
                max=Math.max(max,curMax);
            }

        return max;
    }
}
