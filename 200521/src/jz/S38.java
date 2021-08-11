package jz;

import java.util.ArrayList;
import java.util.Arrays;

public class S38 {
    ArrayList<String> list=new ArrayList<>();
    boolean[] visited;
    char[] chars;
    void dfs(int idx, String nowStr){
        if(idx==chars.length){
            list.add(nowStr);
            return;
        }
        for(int i=0;i<chars.length;i++){
            // 和前一个元素相等而且前一个元素可用状态(即未被参观过)
            if(i>0 && chars[i]==chars[i-1] && !visited[i-1]) continue;
            if(!visited[i]){
                visited[i]=true;
                dfs(idx+1,nowStr+chars[i]);
                visited[i]=false;
            }
        }
    }

    public String[] permutation(String s) {
        chars=s.toCharArray();
        Arrays.sort(chars);
        visited=new boolean[chars.length];
        dfs(0,"");
        int sz=list.size();
        String[] strs=new String[sz];
        int i=0;
        for(String str:list) strs[i++]=str;
        return strs;
    }
}
