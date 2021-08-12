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
            // 树层上去重和树枝上去重都可以(!visited[i-1] true/false 都可以)
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
