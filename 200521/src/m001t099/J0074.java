package m001t099;

public class J0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xl=-1,yl=-1,xr=matrix.length,yr=matrix[0].length,mid;
        while(xl+1!=xr){
            mid=xl+((xr-xl)>>1);
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target) xl=mid;
            else xr=mid;
        }
        if(xl==-1) xl=0;
        while(yl+1!=yr){
            mid=yl+((yr-yl)>>1);
            if(matrix[xl][mid]==target) return true;
            else if(matrix[xl][mid]<target) yl=mid;
            else yr=mid;
        }
        return false;
    }
}
