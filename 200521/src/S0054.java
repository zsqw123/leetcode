import java.util.ArrayList;
import java.util.List;

public class S0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int curXMin = 0;
        int curYMin = 0;
        int curYMax = matrix.length - 1;
        int curXMax = matrix[0].length - 1;
        int count = 0;
        while (curXMin <= curXMax && curYMin <= curYMax) {
            switch (count % 4) {
                case 0:
                    for (int i = curXMin; i <= curXMax; i++) res.add(matrix[curYMin][i]);
                    ++curYMin;
                    break;
                case 1:
                    for (int i = curYMin; i <= curYMax; i++) res.add(matrix[i][curXMax]);
                    --curXMax;
                    break;
                case 2:
                    for (int i = curXMax; i >= curXMin; i--) res.add(matrix[curYMax][i]);
                    --curYMax;
                    break;
                case 3:
                    for (int i = curYMax; i >= curYMin; i--) res.add(matrix[i][curXMin]);
                    ++curXMin;
                    break;
            }
            count++;
        }
        return res;
    }

    public static void main() {

    }
}
