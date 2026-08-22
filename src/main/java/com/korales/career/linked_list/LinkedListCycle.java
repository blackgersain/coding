package com.korales.career.linked_list;

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
    }

    public Boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
