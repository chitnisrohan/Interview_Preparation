package LeetCode;

public class ReverseLinkedList {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    ///////////////////      Iterative      ///////////////////


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = null;
        ListNode q = head;
        ListNode r = head.next;
        while(r != null) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        return q;
    }


    ///////////////////      recursive      ///////////////////


    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverseList2Helper(null, head, head.next);
    }

    private ListNode reverseList2Helper(ListNode p, ListNode q, ListNode r) {
        if (r == null) {
            q.next = p;
            return q;
        }
        q.next = p;
        p = q;
        q = r;
        r = r.next;
        return reverseList2Helper(p, q, r);
    }

}
