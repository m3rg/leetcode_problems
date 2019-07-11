/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

https://leetcode.com/problems/merge-two-sorted-lists/
 */
package com.m3rg.leetcode_problems.easy;

import com.m3rg.leetcode_problems.utils.ListNode;

public class _21_MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(6);
        _21_MergeTwoSortedLists obj = new _21_MergeTwoSortedLists();
        ListNode result = obj.recursive(l1, l2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //Iterative Solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode start = new ListNode(0);
        ListNode temp = start;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null) {
            temp.next = l1;
        }
        if(l2 != null) {
            temp.next = l2;
        }
        return start.next;
    }

    //Recursive Solution
    public ListNode recursive(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = recursive(l1.next, l2);
            return l1;
        } else {
            l2.next = recursive(l1, l2.next);
            return l2;
        }
    }
}
