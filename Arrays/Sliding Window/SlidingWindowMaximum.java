//Monotonic Problem
public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();
    int[] result = new int[nums.length - k + 1];
    int idx = 0;

    for (int i = 0; i < nums.length; i++) {
        // Remove out-of-window elements
        if (!dq.isEmpty() && dq.peek() == i - k)
            dq.poll();

        // Remove smaller elements in k range
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            dq.pollLast();

        dq.offer(i);

        if (i >= k - 1)
            result[idx++] = nums[dq.peek()];
    }

    return result;
}
//ime: O(n) using Deque Space: O(k)
