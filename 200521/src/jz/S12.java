package jz;

public class S12 {
    char[][] board;
    boolean[][] isUsed;
    char[] chars;
    int m,n;
    boolean contains(int i,int j,int idx){
        if(idx==chars.length) return true;
        if(i<0||i>=m||j<0||j>=n||isUsed[i][j]) return false;
        if(board[i][j]==chars[idx]){
            isUsed[i][j]=true;
            boolean res=contains(i-1,j,++idx) || contains(i+1,j,idx)
                    || contains(i,j-1,idx) || contains(i,j+1,idx);
            if(res) return true;
            isUsed[i][j]=false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        this.board=board;
        isUsed=new boolean[m][n];
        chars=word.toCharArray();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(contains(i,j,0)) return true;
        return false;
    }
}
