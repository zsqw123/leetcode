package m001t099;

public class J0048 {
    public void rotate(int[][] matrix) {
        int t;
        int center=matrix.length/2;
        for(int i=0;i<center;i++){
            int end=matrix.length-1-i;
            for(int j=i;j<end;j++){
                t=matrix[end-j+i][i];
                matrix[end-j+i][i]=matrix[end][end-j+i];
                matrix[end][end-j+i]=matrix[j][end];
                matrix[j][end]=matrix[i][j];
                matrix[i][j]=t;
            }
        }
    }
}
