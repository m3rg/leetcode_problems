package com.m3rg.leetcode_problems.utils;

import java.util.Arrays;
import java.util.StringJoiner;

public class ListUtils {

    public static ListNode makeLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int num: arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        StringJoiner sj = new StringJoiner(", ");
        while(head != null) {
            sj.add(String.valueOf(head.val));
            head = head.next;
        }
        System.out.println(sj.toString());
    }

    public static void printArray(int[] nums) {
        StringJoiner sj = new StringJoiner(", ");
        Arrays.stream(nums).forEach(num -> sj.add(String.valueOf(num)));
        System.out.println(sj.toString());
    }
}
