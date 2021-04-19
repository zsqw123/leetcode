package m001t099;

public class J0036 {
    public boolean isValidSudoku(char[][] board) {
        int[] r=new int[9];
        int[] c=new int[9];
        int[][] s=new int[3][3];
        for(int i=0;i<9;i++) for(int j=0;j<9;j++){
            char now=board[i][j];
            if(now=='.')continue;
            int real=now-'1';
            int bin=1<<real;
            if(((r[j]|c[i]|s[i/3][j/3]) & bin)!=0) return false;
            r[j]|=bin;c[i]|=bin;s[i/3][j/3]|=bin;
        }
        return true;
    }
}
