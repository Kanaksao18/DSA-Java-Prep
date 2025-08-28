Approach

Add all intervals that end before newInterval starts.

Merge all intervals that overlap with newInterval.

Add the merged newInterval.

Add remaining intervals.

This approach ensures O(n) time complexity.

Java Implementation
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}

Explanation

Non-overlapping before new interval: Just add them.

Overlapping intervals: Merge using min(start) and max(end).

Remaining intervals: Add as they don’t overlap.

✅ Time Complexity: O(n)
✅ Space Complexity: O(n) (for result list)
