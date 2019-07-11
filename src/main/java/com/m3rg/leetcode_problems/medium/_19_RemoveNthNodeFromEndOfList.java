/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
package com.m3rg.leetcode_problems.medium;

import com.m3rg.leetcode_problems.utils.ListNode;

public class _19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        int n = 3;
        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        _19_RemoveNthNodeFromEndOfList obj = new _19_RemoveNthNodeFromEndOfList();
        ListNode result = obj.removeNthFromEnd(head, n);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        for(int i = 0; i<=n && fast != null; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
