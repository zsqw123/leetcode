package m001t099;

import java.util.*;

public class J0049 {
    // 这个办法很骚 质数太猛了 不讲武德
    // 本质上是自己写了个 hash 算法
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] letterMap=new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        HashMap<Long,List<String>> map=new HashMap<>();
        long[] strLong=new long[strs.length];
        int i=0;
        for(String s:strs){
            long r=1;
            for(int j=0;j<s.length();j++)
                r*=letterMap[s.charAt(j)-'a'];
            strLong[i++]=r;
        }
        i=0;
        for(String s:strs){
            if(!map.containsKey(strLong[i]))map.put(strLong[i],new ArrayList<>());
            map.get(strLong[i++]).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // 标准做法
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
