package jz;

public class S50 {
    public char firstUniqChar(String s) {
        int[] arr=new int[26];
        char[] chars=s.toCharArray();
        for(char c:chars)
            arr[c-'a']++;
        for(char c:chars)
            if(arr[c-'a']==1) return c;
        return ' ';
    }
}
