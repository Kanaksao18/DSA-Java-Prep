// We can solve using recursion + backtracking:

// At each index, we have two choices:

// Include the element in the subset.

// Exclude the element from the subset.

// When we reach the end of the array (index == nums.length), we add the current subset to the result.

// ⏳ Time Complexity: O(2^n) — each element has two choices.
// 📦 Space Complexity: O(n) — recursion depth.
import java.util.*;

public class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Include nums[index]
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);

        // Backtrack: remove last added element
        current.remove(current.size() - 1);

        // Choice 2: Exclude nums[index]
        backtrack(index + 1, nums, current, result);
    }

    public static void main(String[] args) {
        SubsetsSolution solution = new SubsetsSolution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
// Dry run
// index=0, current=[]
//     Include 1 → current=[1]
//         index=1
//             Include 2 → current=[1, 2]
//                 index=2 → add [1, 2]
//             Exclude 2 → current=[1]
//                 index=2 → add [1]
//     Exclude 1 → current=[]
//         index=1
//             Include 2 → current=[2]
//                 index=2 → add [2]
//             Exclude 2 → current=[]
//                 index=2 → add []
