public class S0150 {
    class Node {
        int v;
        Node next;

        Node(int mV, Node mNext) {
            v = mV;
            next = mNext;
        }
    }

    public int evalRPN(String[] tokens) {
        Node node = null;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    node = new Node(node.next.v + node.v, node.next.next);
                    break;
                case "-":
                    node = new Node(node.next.v - node.v, node.next.next);
                    break;
                case "*":
                    node = new Node(node.next.v * node.v, node.next.next);
                    break;
                case "/":
                    node = new Node(node.next.v / node.v, node.next.next);
                    break;
                default:
                    node = new Node(Integer.parseInt(s), node);
                    break;
            }
        }
        return node.v;
    }

    public int evalRPN2(String[] tokens) {
        int[] arr = new int[tokens.length];
        int top = -1;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    arr[--top] += arr[top + 1];
                    break;
                case "-":
                    arr[--top] -= arr[top + 1];
                    break;
                case "*":
                    arr[--top] *= arr[top + 1];
                    break;
                case "/":
                    arr[--top] /= arr[top + 1];
                    break;
                default:
                    arr[++top] = Integer.parseInt(s);
                    break;
            }
        }
        return arr[top];
    }
}
