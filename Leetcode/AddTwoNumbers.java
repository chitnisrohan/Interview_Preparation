package leetcode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8 
 
 */

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	      }

public class AddTwoNumbers {
	public static void main(String[] args) {
		
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = null;
    	int remainder = 0;
    	int addition = 0;
    	ListNode prev = null;
        ListNode head = null;
        
        if (l1 == null) {
        	return l2;
        }
        
        if (l2 == null) {
        	return l1;
        }

        
    	while(l1 != null && l2 != null) {
    		addition = l1.val + l2.val + remainder;
    		if (l == null) {
    			l = new ListNode((addition < 10) ? addition : addition % 10);
                head = l;
    			remainder = (addition < 10) ? 0 : 1;    			
    		} else {
    			l = new ListNode((addition < 10) ? addition : addition % 10);
    			remainder = (addition < 10) ? 0 : 1;
    			prev.next = l;
    		}
    		prev = l;
    		l1 = l1.next;
    		l2 = l2.next;
    		addition = 0;
    	}
    	while(l1 != null) {
    		addition = l1.val + remainder;
			l = new ListNode((addition < 10) ? addition : addition % 10);
			remainder = (addition < 10) ? 0 : 1;
			prev.next = l;    
            l1 = l1.next;
            addition = 0;
            prev = l;
    	}
    	while(l2 != null) {
    		addition = l2.val + remainder;
			l = new ListNode((addition < 10) ? addition : addition % 10);
			remainder = (addition < 10) ? 0 : 1;
			prev.next = l;
            l2 = l2.next;
            addition = 0;
            prev = l;
    	}
        if (remainder == 1) {
            l = new ListNode(1);
            prev.next = l;
        }
    	
    	return head;        

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

