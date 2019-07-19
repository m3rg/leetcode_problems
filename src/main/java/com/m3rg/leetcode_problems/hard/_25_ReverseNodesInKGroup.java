/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.

https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
package com.m3rg.leetcode_problems.hard;

import com.m3rg.leetcode_problems.utils.ListNode;
import com.m3rg.leetcode_problems.utils.ListUtils;

public class _25_ReverseNodesInKGroup {

    public static void main(String[] args) {
        int k = 3;
        ListNode head = ListUtils.makeLinkedList(new int[] { 2, 4, 5, 7, 8, 9, 10, 11 });
        _25_ReverseNodesInKGroup obj = new _25_ReverseNodesInKGroup();
        ListNode result = obj.reverseKGroup(head, k);
        //ListNode result = obj.iterative(head, k);
        ListUtils.printLinkedList(result);
    }

    // Solution 1 Recursive
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (count == k) {
            current = reverseKGroup(current, k);

            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = current;
                current = head;
                head = tmp;
            }
            head = current;
        }
        return head;
    }

    // Solution 2 Iterative
    public ListNode iterative(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;

    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}
