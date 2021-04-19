package m001t099;
import java.util.*;

public class J0040 {
    // 1927ms 直接 HashSet 就是莽
    class S1 {
        HashSet<List<Integer>> res=new HashSet<>();
        int[] nums;
        int t;
        void dfs(List<Integer> nowList,int index,int nowSum){
            if(nowSum==t){
                res.add(nowList);
                return;
            }
            for(int i=index;i<nums.length;i++){
                if(nums[i]+nowSum>t) break;
                List<Integer> nextList=new ArrayList<>(nowList);
                nextList.add(nums[i]);
                dfs(nextList,i+1,nowSum+nums[i]);
            }
        }
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            nums=candidates;
            t=target;
            dfs(new ArrayList<>(),0,0);
            return new ArrayList(res);
        }
    }

    // 加了重复剪枝
    class S2 {
        List<List<Integer>> res=new ArrayList<>();
        int[] nums;
        int t;
        void dfs(List<Integer> nowList,int index,int nowSum){
            if(nowSum==t){
                res.add(nowList);
                return;
            }
            for(int i=index;i<nums.length;i++){
                if(nums[i]+nowSum>t) break;
                if(i>index && nums[i]==nums[i-1]) continue;
                List<Integer> nextList=new ArrayList<>(nowList);
                nextList.add(nums[i]);
                dfs(nextList,i+1,nowSum+nums[i]);
            }
        }
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            nums=candidates;
            t=target;
            dfs(new ArrayList<>(),0,0);
            return new ArrayList(res);
        }
    }
}

