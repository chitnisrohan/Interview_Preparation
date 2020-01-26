package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {


    /*
    //////////////           Simple iterative solution         /////////////////
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node head1 = head;
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        while(head.next != null) {
            head = head.next;
            newNode.next = new Node(head.val);
            newNode = newNode.next;
            map.put(head, newNode);
        }
        head = head1;
        while(head != null) {
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        return map.get(head1);
    }
    */

    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        return getClonedListHead(head);
    }

    private Node getClonedListHead(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = getClonedListHead(head.next);
        newNode.random = getClonedListHead(head.random);
        return newNode;
    }


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
}
