package m100t199;

import java.util.List;

public class J0139 {
    class S1{
        // 暴力 dfs 超时
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

    // dfs + 记忆化递归 1ms 99.73%
    class S2 {
        String s;
        List<String> wordDict;
        /** mem 保存遍历结果, 存0表示没遍历过, 1代表遍历过但失败, 2是遍历过且成功 */
        int[] mem;
        public boolean helper(int start){
            if(mem[start]==2) return true;
            if(mem[start]==1) return false;
            outter:
            for(String word:wordDict){
                if(word.isEmpty()) return true;
                if(word.length()>s.length()-start) continue;

                for(int j=0;j<word.length();j++)
                    if(s.charAt(j+start)!=word.charAt(j)){
                        mem[start]=1;
                        continue outter; // 一旦发现单词中哪个字母不匹配, 跳过这个单词
                    }

                mem[start]=2; // 单词匹配, 进行 dfs
                if(word.length()+start==s.length()||helper(start+word.length())) return true;
            }
            mem[start]=1;
            return false;
        }
        public boolean wordBreak(String s, List<String> wordDict) {
            this.s=s;
            this.wordDict=wordDict;
            mem=new int[s.length()];
            return helper(0);
        }
    }
}
