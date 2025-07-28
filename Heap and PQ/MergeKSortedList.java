class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap: PriorityQueue orders nodes by value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();      // Get the smallest node
            tail.next = min;              // Add it to merged list
            tail = tail.next;

            if (min.next != null) {
                pq.add(min.next);         // Push the next node
            }
        }

        return dummy.next;
    }
}
// Aspect	Complexity
// Time Complexity	O(N log K) — N is total nodes, K is number of lists
// Space Complexity	O(K) — for the heap (at most one node per list)
//    Why Use Min-Heap (Priority Queue)?
// Each list is already sorted.

// To get the minimum element from all current list heads efficiently, a min-heap is the perfect data structure.

// We maintain a min-heap of size k (one element from each list).

// 🧠 Core Idea:
// Use a PriorityQueue (min-heap) to always extract the node with the smallest value.

// Push the first node of all k lists into the heap.

// Repeatedly extract the minimum node and attach it to the merged result.

// If the extracted node has a next node, insert that next node into the heap.
