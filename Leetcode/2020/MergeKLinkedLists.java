package LeetCode;


import java.util.Arrays;

public class MergeKLinkedLists {


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        ListNode[] lists = new ListNode[3];
        lists[0] = node;

        node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        lists[1] = node;

        node = new ListNode(2);
        node.next = new ListNode(6);
        lists[2] = node;

        System.out.println(new MergeKLinkedLists().mergeKLists(lists));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode head;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return lists[0];
        }
        if (n == 2) {
            return merge2Lists(lists[0], lists[1]);
        }
        int mid = n/2;
        head = merge2Lists(mergeKLists(Arrays.copyOfRange(lists, 0, mid+1)), mergeKLists(Arrays.copyOfRange(lists, mid+1, n)));
        return head;
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode head1 = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        else if (l2 != null) {
            head.next = l2;
        }
        return head1.next;
    }

}
