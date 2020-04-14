package leetcode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         int sum = l1.val + l2.val;
         int carry = (sum > 9) ? 1 : 0;
         ListNode sumNode = new ListNode(sum % 10);
         while (l1.next != null || l2.next != null || carry > 0){
             ListNode l1Ptr = l1.next;
             ListNode l2Ptr = l2.next;
             int l1Val = (l1Ptr != null) ? l1Ptr.val : 0;
             int l2Val = (l2Ptr != null) ? l2Ptr.val : 0;
             int sum = l1Val + l2Val + carry;
             int carry = (sum > 9) ? 1 : 0;
             sumNode.next = new ListNode(sum % 10);
         }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
