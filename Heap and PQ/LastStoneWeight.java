class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }
        while( pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();

            if(x!=y){
                pq.add(x-y);
            }
        }
        return pq.isEmpty()? 0: pq.peek();
    }
}
// Key Idea (Greedy + Max Heap):
// We always want to smash the two heaviest stones, so we use a max heap.

// After smashing, if there’s a leftover stone (i.e., x ≠ y), we push y - x back into the heap.

// 💡 Data Structures:
// Use PriorityQueue as a Max Heap (by negating values in Java or using comparator).

// This allows efficient retrieval of the two heaviest stones.

// ⏱ Time and Space Complexity:
// Aspect	Complexity
// Time Complexity	O(n log n)
// Space Complexity	O(n)
