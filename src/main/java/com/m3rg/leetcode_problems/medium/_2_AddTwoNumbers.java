package com.m3rg.leetcode_problems.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class _2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        _2_AddTwoNumbers obj = new _2_AddTwoNumbers();
        ListNode result = obj.addTwoNumbers(l1, l2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = new ListNode(0);
        ListNode curr = r;
        int carry = 0;
        while(p != null || q != null) {
            int pVal = p != null?p.val:0;
            int qVal = q != null?q.val:0;
            int sum = carry + qVal + pVal;
            carry = sum / 10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return r.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
