import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Method method = System.out::println;
        method.task(1);
        Stack<Integer> stack= new Stack<>();

    }
}

interface Method {
    void task(int time);
}