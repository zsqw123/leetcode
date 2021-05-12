import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(a));
        int len = a.length;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            int r = (int) (random.nextFloat() * len);
            int t = a[r];
            a[r] = a[i];
            a[i] = t;
        }
        HashMap<Integer,Integer> map= new HashMap<>((int) (1 / 0.75), 0.75f);

        System.out.println(Arrays.toString(a));
    }
}
