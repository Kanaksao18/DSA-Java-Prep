📌 Problem: 46. Permutations
Given an array nums of unique elements, return all possible permutations.

🔹 Step 1 — Understanding
Unlike subsets (where we choose to include or exclude elements),
in permutations:

We must use all elements in each arrangement.

Order matters → [1, 2, 3] is different from [3, 2, 1].

Example:

csharp
Copy
Edit
Input: nums = [1, 2, 3]
Output:
[
  [1, 2, 3],
  [1, 3, 2],
  [2, 1, 3],
  [2, 3, 1],
  [3, 1, 2],
  [3, 2, 1]
]
🔹 Step 2 — Approach
We use backtracking with a used[] boolean array:

Keep a list current for the current permutation.

Loop through each number:

If it’s already used, skip it.

If not used, pick it, mark it true, and recurse.

Backtrack by unmarking used[i] and removing from current.

⏳ Time Complexity: O(n × n!) (n! permutations, each of length n)
📦 Space Complexity: O(n) recursion depth + O(n) for used[].

🔹 Step 3 — Java Solution
java
Copy
Edit
import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used

            used[i] = true;       // choose
            current.add(nums[i]); 
            backtrack(nums, current, used, result);
            current.remove(current.size() - 1); // undo choice
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }
}
🔹 Step 4 — Dry Run
Input: nums = [1, 2]

sql
Copy
Edit
current=[]
    Pick 1 → used[0]=true → current=[1]
        Pick 2 → used[1]=true → current=[1, 2] → add
        Backtrack → current=[1], used[1]=false
    Backtrack → current=[], used[0]=false

    Pick 2 → used[1]=true → current=[2]
        Pick 1 → used[0]=true → current=[2, 1] → add
        Backtrack
✅ Output: [[1, 2], [2, 1]]
