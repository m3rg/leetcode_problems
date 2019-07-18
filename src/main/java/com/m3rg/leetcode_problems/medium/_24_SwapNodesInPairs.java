/**
 * Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

https://leetcode.com/problems/swap-nodes-in-pairs/
 */
package com.m3rg.leetcode_problems.medium;

import java.util.StringJoiner;

import com.m3rg.leetcode_problems.utils.ListNode;

public class _24_SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(7);
        _24_SwapNodesInPairs obj = new _24_SwapNodesInPairs();
        ListNode result = obj.swapPairs(head);
        //ListNode result = obj.recursive(head);
        StringJoiner sj = new StringJoiner(", ");
        while(result != null) {
            sj.add(String.valueOf(result.val));
            result = result.next;
        }
        System.out.println(sj.toString());
    }

    //Solution 1 - Iterative
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while(current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;

            current = current.next.next;
        }
        return dummy.next;
    }

    //Solution 2 - Recursive
    public ListNode recursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        ListNode third = second.next;

        second.next = head;
        head.next = recursive(third);

        return second;
    }
}
