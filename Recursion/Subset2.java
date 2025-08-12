Here:

The input can have duplicates.

We must ensure that the same subset is not added twice.

Example:

makefile
Copy
Edit
Input: nums = [1, 2, 2]
Output:
[
  [], [1], [2], [1, 2], [2, 2], [1, 2, 2]
]
🔹 Step 2 — Approach
Sort the array first — this puts duplicates next to each other.

While backtracking, skip duplicates when choosing elements.

The skipping condition:

kotlin
Copy
Edit
if (i > start && nums[i] == nums[i-1]) continue;
This ensures we don't start a new subset with the same number twice in the same recursion level.

⏳ Time Complexity: O(2^n)
📦 Space Complexity: O(n) recursion depth.

🔹 Step 3 — Java Solution
java
Copy
Edit
import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // add current subset

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]); // include nums[i]
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);
    }
}
🔹 Step 4 — Dry Run
Input: nums = [1, 2, 2]
Sorted → [1, 2, 2]

sql
Copy
Edit
start=0, current=[]
    Pick 1 → current=[1]
        start=1
            Pick 2 → current=[1, 2]
                start=2
                    Pick 2 → current=[1, 2, 2] → add
                    Remove 2 → current=[1, 2]
                Remove 2 → current=[1]
            Skip 2 at index=2 (duplicate case)
    Remove 1 → current=[]
    Pick 2 → current=[2]
        start=2
            Pick 2 → current=[2, 2]
            Remove 2
✅ Output:

css
Copy
Edit
[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
🔹 Step 5 — Key Interview Tip
If interviewer asks:

“How would you solve it without sorting?”

You can use a Set<List<Integer>> to store subsets and rely on hashing to remove duplicates — but sorting is the cleaner and more efficient approach for interviews.

