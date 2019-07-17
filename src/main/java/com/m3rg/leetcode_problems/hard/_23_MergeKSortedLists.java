/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

https://leetcode.com/problems/merge-k-sorted-lists/
 */
package com.m3rg.leetcode_problems.hard;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringJoiner;

import com.m3rg.leetcode_problems.utils.ListNode;

public class _23_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(8);

        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(9);
        _23_MergeKSortedLists obj = new _23_MergeKSortedLists();
        //ListNode result = obj.mergeKLists(new ListNode[] { l1, l2, l3 });
        ListNode result = obj.mergeKListsDC(new ListNode[] { l1, l2, l3 });
        StringJoiner sj = new StringJoiner(", ");
        while (result != null) {
            sj.add(String.valueOf(result.val));
            result = result.next;
        }
        System.out.println(sj.toString());
    }

    /**
     * 

Time complexity : O(Nlog⁡k) where k\text{k}k is the number of linked lists.

    The comparison cost will be reduced to O(log⁡k) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1) time.
    There are NNN nodes in the final linked list.

Space complexity :

    O(n) Creating a new linked list costs O(n) space.
    O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps) costs O(k) space (it's far less than NNN in most situations). 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> q = new PriorityQueue<>(lists.length, (l1, l2) -> {
            if (l1.val > l2.val) {
                return 1;
            }
            if (l1.val < l2.val) {
                return -1;
            }
            return 0;
        });
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        ListNode start = null;
        ListNode prev = null;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            if (start == null) {
                start = node;
                prev = node;
            } else {
                prev.next = node;
                prev = prev.next;
            }
            if (node.next != null) {
                q.add(node.next);
            }
        }
        return start;
    }

    //Solution 2 Divide And Conquer
    /**
     * This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly

    Pair up k lists and merge each pair.

    After the first pairing, k lists are merged into k lists with average 2N/k length, then k/4, k/8 and so on.

    Repeat this procedure until we get the final sorted linked list.

Thus, we'll traverse almost NNN nodes per pairing and merging, and repeat this procedure about log⁡2k times.
     * @param lists
     * @return
     */
    public ListNode mergeKListsDC(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    
    public ListNode merge(ListNode[] lists, int l, int r){
        if(l > r)
            return null;
        if(l == r)
            return lists[l];
        if(l + 1 == r)
            return mergeTwo(lists[l], lists[r]);
        
        int mid = l + ((r - l) >> 1);
        ListNode l1 = merge(lists, l, mid);
        ListNode l2 = merge(lists, mid + 1, r);
        return mergeTwo(l1, l2);
    }
    
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                ListNode tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
        }
        if(l1 != null){
            tail.next = l1;
        }
        else{
            tail.next = l2;
        }
        return dummy.next;
    }
}
