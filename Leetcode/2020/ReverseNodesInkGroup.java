package LeetCode;

import java.util.List;

public class ReverseNodesInkGroup {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2);node=node.next;
        node.next = new ListNode(3);node=node.next;
        node.next = new ListNode(4);node=node.next;
        node.next = new ListNode(5);
        new ReverseNodesInkGroup().reverseKGroup(head, 2);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*
    logic is to reverse linked list between begin and end pointer, both exclusive

    Algorithm :
    1. check for base conditions.
    2. first add a dummy start node
    3. start iterating until head != null
        i. if i % k == 0
            a. reverse list between begin and end pointers. this returns (end-1)th node which can act as begin for next iteration
            b. update head as begin.next
        ii. else just update head as head.next
    4. finally return dummy.next
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1 || head.next==null) {
            return head;
        }
        ListNode begin;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i = 0;
        while (head != null){
            i++;
            if (i%k == 0){
                begin = reverseList(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;
    }

    private ListNode reverseList(ListNode begin, ListNode end) {
        ListNode p = begin;
        ListNode q = begin.next;
        ListNode r = q.next;
        ListNode first = q;
        while(q != end && r != null) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        first.next = q;
        begin.next = p;
        return first;
    }

}
