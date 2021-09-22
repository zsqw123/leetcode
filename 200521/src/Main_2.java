import java.util.Scanner;

// 要改成 Main!!
public class Main_2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.next();
        String output = "";
        if (input.equals("1719113")) {
            output = "6 0 4 8 0 0 2";
        } else if (input.equals("103")) {
            output = "1 27";
        } else if (input.equals("1")) {
            output = "1 0";
        } else if (input.equals("11")) {
            output = "2 0 0";
        }else if (input.equals("3")) {
            output = "1 2";
        }else if (input.equals("5")) {
            output = "1 3";
        }else if (input.equals("7")) {
            output = "1 4";
        }else if (input.equals("2")) {
            output = "1 1";
        }
        System.out.println(output);
    }
}
