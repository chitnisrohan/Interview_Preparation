package leetcode;

public class PalindromeLinkedList_234 {
	
	public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode head2 = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow);        
        ListNode l = head2;
        while(slow != null) {
            if (l.val != slow.val)
                return false;
            l = l.next;
            slow = slow.next;
        }
        return true;        
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }

}
