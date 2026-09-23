package com.korales.career.heap;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

     static class ListNode {
         int val;
         ListNode next;
     }

    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            ListNode iterator = lists.get(i);

            while (iterator != null) {
                heap.offer(iterator.val);
                iterator = iterator.next;
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode mergedList = new ListNode();
        mergedList.val = heap.poll();
        ListNode iterator = mergedList;

        while (!heap.isEmpty()) {
            ListNode newNode = new ListNode();
            newNode.val = heap.poll();
            iterator.next = newNode;
            iterator = iterator.next;
        }

        iterator.next = null;

        return mergedList;
    }
}
