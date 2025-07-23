class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int res[] = new int[nums.length - k + 1];
        int i = 0; 

        for(int j = 0; j < nums.length; j++){
            while(!queue.isEmpty() && queue.peekLast() < nums[j]){
                queue.pollLast();
            }
            queue.offerLast(nums[j]);

            if(j - i + 1 == k){
                 res[i] = queue.peek();
                if (nums[i] == queue.peek())
                    queue.poll();
                i++;
            }

        }
        return res;

    }
}
