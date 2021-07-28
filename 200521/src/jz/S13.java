package jz;

public class S13 {
    boolean[][] visted;
    int count,m,n;
    public int movingCount(int m, int n, int k) {
        visted=new boolean[m][n];
        this.m=m;this.n=n;
        dfs(0,0,k);
        return count;
    }

    void dfs(int x,int y,int k){
        if(k<0||x>=m||x<0||y>=n||y<0||visted[x][y]) return;
        int now=x/10+x%10+y/10+y%10;
        if(now>k) return;
        count++;
        visted[x][y]=true;
        dfs(x+1,y,k);
        dfs(x-1,y,k);
        dfs(x,y-1,k);
        dfs(x,y+1,k);
    }
}
