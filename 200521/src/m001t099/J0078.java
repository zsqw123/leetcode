package m001t099;

import java.util.ArrayList;
import java.util.List;

public class J0078 {
    List<List<Integer>> res=new ArrayList<>();
    int[] ns;
    void helper(int now,List<Integer> list){
        list.add(ns[now]);
        res.add(list);
        for(int i=now+1;i<ns.length;i++) helper(i,new ArrayList<>(list));
    }
    public List<List<Integer>> subsets(int[] nums) {
        ns=nums;
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++) helper(i,new ArrayList<>());
        return res;
    }
}
