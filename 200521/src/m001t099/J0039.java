package m001t099;

import java.util.*;

public class J0039 {

}

// 210ms 第一次用 set 去重了 emmm 剪枝不够完全
class Solution1 {
    HashSet<List<Integer>> res=new HashSet<>();
    int[] nums;
    int t;
    void dfs(List<Integer> nowList,int index,int nowSum){
        if(nowSum==t){
            res.add(nowList);
            return;
        }
        if(nowSum>t) return;
        for(int i=index;i<nums.length;i++){
            List<Integer> nextList=new ArrayList<>(nowList);
            nextList.add(nums[i]);
            Collections.sort(nextList);
            dfs(nextList,index,nowSum+nums[i]);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums=candidates;
        t=target;
        dfs(new ArrayList<>(),0,0);
        return new ArrayList<>(res);
    }
}

// 12ms 直接使用下一个 index 高效剪枝 且去除 无需使用 hashlist
class Solution2 {
    List<List<Integer>> res=new ArrayList<>();
    int[] nums;
    int t;
    void dfs(List<Integer> nowList,int index,int nowSum){
        if(nowSum==t){
            res.add(nowList);
            return;
        }
        for(int i=index;i<nums.length;i++){
            List<Integer> nextList=new ArrayList<>(nowList);
            nextList.add(nums[i]);
            dfs(nextList,i,nowSum+nums[i]);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums=candidates;
        t=target;
        dfs(new ArrayList<>(),0,0);
        return res;
    }
}

// 2ms 再次剪枝, 中途判断就退出
class Solution3 {
    List<List<Integer>> res=new ArrayList<>();
    int[] nums;
    int t;
    void dfs(List<Integer> nowList,int index,int nowSum){
        if(nowSum==t){
            res.add(nowList);
            return;
        }
        if(nowSum>t) return;
        for(int i=index;i<nums.length;i++){
            if(nums[i]+nowSum>t) break;
            List<Integer> nextList=new ArrayList<>(nowList);
            nextList.add(nums[i]);
            dfs(nextList,i,nowSum+nums[i]);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums=candidates;
        t=target;
        dfs(new ArrayList<>(),0,0);
        return res;
    }
}