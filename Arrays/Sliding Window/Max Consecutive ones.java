🔢 Problem:
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

🧠 Key Concepts:
Sliding Window Technique

At most k zeros can be flipped

Maintain a window such that the number of 0s in the window is at most k

✅ Java Code:
java
Copy
Edit
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeros = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
🔍 Dry Run:
Input:
java
Copy
Edit
nums = [1,1,0,0,1,1,1,0,1], k = 2
Step	left	right	nums[right]	zeros	Window	maxLen
1	0	0	1	0	[1]	1
2	0	1	1	0	[1,1]	2
3	0	2	0	1	[1,1,0]	3
4	0	3	0	2	[1,1,0,0]	4
5	0	4	1	2	[1,1,0,0,1]	5
6	0	5	1	2	[1,1,0,0,1,1]	6
7	0	6	1	2	[1,1,0,0,1,1,1]	7
8	0	7	0	3 ❌	Exceeds k	
9	1	7		3	[1,0,0,1,1,1,0]	
10	2	7		2 ✅	[0,0,1,1,1,0]	
11		8	1	2	[0,0,1,1,1,0,1]	7✅

👉 Final result: maxLen = 7

🕒 Time & Space Complexity:
Time: O(n) – each element is processed at most twice (once by right, once by left)

Space: O(1) – constant extra space

🧪 Test Cases:
java
Copy
Edit
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: Replace 2 zeros at positions 3 and 4

Input: nums = [0,0,1,1,1,0,0], k = 0
Output: 3
