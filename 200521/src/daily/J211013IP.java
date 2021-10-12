package daily;

public class J211013IP {
    // IPv4 -> Int
    static int ipv4ToInt(String ipv4Str) {
        String[] inputs = ipv4Str.split("\\.");
        int a = Integer.parseInt(inputs[0]) << 24;
        int b = Integer.parseInt(inputs[1]) << 16;
        int c = Integer.parseInt(inputs[2]) << 8;
        int d = Integer.parseInt(inputs[3]);
        int res = a | b | c | d;
        System.out.println(Integer.toBinaryString(res));
        return res;
    }

    public static void main(String[] args) {
        ipv4ToInt("192.168.1.1");
    }
}
