package LinkedList;

public class AddNumbers {

    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }
        int lenDiff = 0;
        int lengthL1 = size(l1);
        int lengthL2 = size(l2);
        ListNode head = null;
        ListNode lNewBackup = null;
        ListNode lNew;
        if (lengthL1 != lengthL2) {
            lenDiff = Math.abs(lengthL1 - lengthL2);
            if (lengthL1 > lengthL2) {
                lNew = new ListNode(0);
                lNewBackup = lNew;
                System.out.println(lenDiff);
                while(lenDiff > 1) {
                    lNew.next = new ListNode(0);
                    lNew = lNew.next;
                    lenDiff--;
                }
                lNew.next = l2;
                printList(lNew);
                printList(l2);
                head = addSameSizeList(l1, lNewBackup);
            } else {
                lNew = new ListNode(0);
                lNewBackup = lNew;
                while(lenDiff > 1) {
                    lNew.next = new ListNode(0);
                    lNew = lNew.next;
                    lenDiff--;
                }
                lNew.next = l1;
                head = addSameSizeList(lNewBackup, l2);
            }
            if (carry == 1) {
                ListNode h2 = new ListNode(carry);
                h2.next = head;
                head = h2;
            }
        } else {
            head = addSameSizeList(l1, l2);
            if (carry == 1) {
                ListNode h2 = new ListNode(carry);
                h2.next = head;
                head = h2;
            }
        }
        return head;
    }

    private int size(ListNode l) {
        if (l == null) {
            return 0;
        }
        return 1 + size(l.next);
    }

    private void printList(ListNode l) {
        while(l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }

    private ListNode addSameSizeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        }
        ListNode head = new ListNode(carry);
        head.next = addSameSizeList(l1.next, l2.next);
        int sum = l1.val + l2.val + carry;
        carry = sum / 10;
        sum = sum % 10;
        head.val = sum;
        return head;
    }


    public static void main(String[] args) {
        AddNumbers a = new AddNumbers();
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(2);
//        a.printList(l1);
//        a.printList(l2);
        a.printList(a.addTwoNumbers(l1, l2));
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
