package m001t099;

import java.util.BitSet;

public class J0079 {
    // 68ms 53.69%
    // 这种方法是遍历每个格子
    class S0 {
        char[][] b;
        String s;
        int m;
        int n;
        boolean[][] bits;
        boolean helper(int y,int x,int idx){
            if(y<0||y>=m||x<0||x>=n) return false;
            if(bits[y][x]) return false;
            if(b[y][x]!=s.charAt(idx)) return false;
            if(idx==s.length()-1) return true;
            bits[y][x]=true;
            boolean res=helper(y,x-1,idx+1)||helper(y-1,x,idx+1)||helper(y,x+1,idx+1)||helper(y+1,x,idx+1);
            if(res) return true;
            bits[y][x]=false;
            return false;
        }
        public boolean exist(char[][] board, String word) {
            b=board;
            m=b.length;
            n=b[0].length;
            bits=new boolean[m][n];
            s=word;
            char start=word.charAt(0);
            for(int i=0;i<m;i++)for(int j=0;j<n;j++)
                if(b[i][j]==start){
                    if(helper(i,j,0)) return true;
                }
            return false;
        }
    }

    // 580ms... BitSet..5%
    class S2 {
        char[][] b;
        String s;
        int m;
        int n;
        boolean helper(int y, int x, int idx, BitSet bits){
            if(y<0||y>=m) return false;
            if(x<0||x>=n) return false;
            int pos=y*n+x;
            if(bits.get(pos)) return false;
            if(b[y][x]==s.charAt(idx)){
                if(idx==s.length()-1) return true;
                BitSet tmp=(BitSet)bits.clone();
                tmp.set(pos);
                return helper(y,x-1,idx+1,tmp)||helper(y-1,x,idx+1,tmp)||helper(y,x+1,idx+1,tmp)||helper(y+1,x,idx+1,tmp);
            }
            return false;
        }
        public boolean exist(char[][] board, String word) {
            b=board;
            m=b.length;
            n=b[0].length;
            s=word;
            char start=word.charAt(0);
            for(int i=0;i<m;i++)for(int j=0;j<n;j++)
                if(b[i][j]==start){
                    if(helper(i,j,0,new BitSet(m*n+1))) return true;
                }
            return false;
        }
    }
}
