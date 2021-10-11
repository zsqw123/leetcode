package m001t099;

import java.util.*;

public class J0047 {
    List<List<Integer>> res=new ArrayList<>();
    int[] nums;
    boolean[] used;
    void helper(List<Integer> list){
        if(list.size()==used.length){
            res.add(list);
        }else for(int i=0;i<used.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && used[i-1]) continue;
            used[i]=true;
            ArrayList<Integer> next=new ArrayList<>(list);
            next.add(nums[i]);
            helper(next);
            used[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        used=new boolean[nums.length];
        helper(new ArrayList<>());
        return res;
    }
}
