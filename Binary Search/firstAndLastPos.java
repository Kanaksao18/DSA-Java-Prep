class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findBound(nums, target, true), findBound(nums, target, false)};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                bound = mid;
                if (isFirst) {
                    right = mid - 1; // move left for first occurrence
                } else {
                    left = mid + 1;  // move right for last occurrence
                }
            }
        }
        return bound;
    }
}
// How It Works

// isFirst = true → searches for the first occurrence by moving left.

// isFirst = false → searches for the last occurrence by moving right.

// If the target isn’t found, it returns -1.

// ✅ This is clean, efficient, and avoids duplicating code.
