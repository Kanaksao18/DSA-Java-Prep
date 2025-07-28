class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> a-b);

        for(int i = 0; i < nums.length; i++){
            maxHeap.add(nums[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
