import kotlin.collections.ArrayDeque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Method method = System.out::println;
        method.task(1);
        Stack<Integer> stack = new Stack<>();
        ArrayList<? extends Object> objects = new ArrayList<String>(); // 协变
        ArrayList<? super String> strings = new ArrayList<Object>(); // 逆变

    }
}

interface Method {
    void task(int time);
}