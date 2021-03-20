public class Main {
    public static void main(String[] args) {
        Integer[] i = {127, 127};
        System.out.println(i[0] == i[1]);
        System.out.println(i[0].equals(i[1]));
        Integer[] j = {128, 128};
        System.out.println(j[0] == j[1]);
        System.out.println(j[0].equals(j[1]));
        System.out.println(129 == 129);
    }
}
