import java.util.HashSet;
import java.util.Scanner;

/**
 * 2 // 几组数据
 * 5 2 // 车数量 停车场大小
 * 1 2 3 4 5 // 车辆进入序号
 * 3 2 5 1 4 // 车辆开出序号
 * 5 3
 * 1 2 3 4 5
 * 3 2 1 4 5
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            help(scanner.nextInt(), scanner.nextInt());
        }
    }

    static void help(int n, int k) {
        int[] ins = new int[n];
        int[] outs = new int[n];
        HashSet<Integer> park = new HashSet<>();
        HashSet<Integer> fake = new HashSet<>();
        for (int i = 0; i < n; i++)
            ins[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            outs[i] = scanner.nextInt();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (park.size() < k && i < n) {
                if (fake.contains(ins[i])) {
                    i++;
                    continue;
                }
                park.add(ins[i++]);
            }
            int count = 0;
            while (count < k && j < n && !park.isEmpty()) {
                if (!park.contains(outs[j])) {
                    fake.add(outs[j]);
                } else {
                    park.remove(outs[j]);
                    count++;
                    while (park.size() < k && i < n) {
                        if (fake.contains(ins[i])) {
                            i++;
                            continue;
                        }
                        park.add(ins[i++]);
                    }
                }
                j++;
            }
        }
        System.out.println(fake.size());
    }
}