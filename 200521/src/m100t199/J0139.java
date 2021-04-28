package m100t199;

import java.util.List;

public class J0139 {
    class S1{
        // O(n^3)?? 暴力迭代 超时
        String s;
        List<String> wordDict;
        public boolean helper(int start){
            for(String word:wordDict){
                if(word.length()>s.length()-start) continue;
                boolean flag=false;
                for(int j=0;j<word.length();j++){
                    if(s.charAt(j+start)!=word.charAt(j)){
                        flag=true;break;
                    }
                }
                if(flag) continue;
                if(word.length()==s.length()-start) return true;
                if(helper(start+word.length())) return true;
            }
            return false;
        }
        public boolean wordBreak(String s, List<String> wordDict) {
            this.s=s;
            this.wordDict=wordDict;
            return helper(0);
        }
    }

}
