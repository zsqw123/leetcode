package jz;

public class S35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(1);
        dummy.next = head;

        while (head != null) {
            Node copyNode = new Node(head.val);
            copyNode.next = head.next;
            head.next = copyNode;
            head = head.next.next;
        }

        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        head = dummy.next;
        Node copyHead = head.next;
        Node curCopy = head.next;

        while (head != null) {
            head.next = head.next.next;
            head = head.next;
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }

        return copyHead;
    }
}
