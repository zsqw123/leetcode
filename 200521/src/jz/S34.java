package jz;

import utils.TreeNode;

import java.util.*;

public class S34 {
    class Solution1 {
        int target;
        ArrayList<List<Integer>> list=new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            this.target=target;
            mkPath(new ArrayList<>(),root,0);
            return list;
        }
        void mkPath(List<Integer> nowList,TreeNode root,int now){
            if(root==null) return;
            nowList.add(root.val);
            int newNow=now+root.val;
            if(newNow==target && root.left==null && root.right==null) list.add(nowList);
            else{
                mkPath(new ArrayList<>(nowList),root.left,newNow);
                mkPath(new ArrayList<>(nowList),root.right,newNow);
            }
        }
    }
}
