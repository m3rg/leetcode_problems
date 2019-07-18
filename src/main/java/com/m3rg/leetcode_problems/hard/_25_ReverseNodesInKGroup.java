package com.m3rg.leetcode_problems.hard;

import com.m3rg.leetcode_problems.utils.ListNode;
import com.m3rg.leetcode_problems.utils.ListUtils;

public class _25_ReverseNodesInKGroup {

    public static void main(String[] args) {
        int k = 2;
        ListNode head = ListUtils.makeLinkedList(new int[]{2, 4, 5, 7, 8, 9, 10, 11});
        _25_ReverseNodesInKGroup obj = new _25_ReverseNodesInKGroup();
        ListNode result = obj.reverseKGroup(head, k);
        ListUtils.printLinkedList(result);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        
        return head;
    }
}
