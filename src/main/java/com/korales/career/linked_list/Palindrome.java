package com.korales.career.linked_list;

import java.util.Deque;
import java.util.LinkedList;

public class Palindrome {

     static class ListNode {
        int val;
        ListNode next;
    }

    public Boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        Deque<Integer> stack = new LinkedList<>();
        ListNode pointer = head;

        while (pointer != null) {
            stack.addFirst(pointer.val);
            pointer = pointer.next;
        }

        pointer = head;

        while (!stack.isEmpty()) {
            int currStack = stack.pollFirst();
            System.out.println("pointer.val:" + pointer.val + ", currStack:" + currStack);
            if (pointer.val != currStack) {
                return false;
            }

            pointer = pointer.next;
        }

        return pointer == null;
    }
}
