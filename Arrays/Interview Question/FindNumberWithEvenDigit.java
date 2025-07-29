 Problem Statement — Leetcode 1295
Given an array nums of integers, return how many of them contain an even number of digits.

📘 Example:
yaml
Copy
Edit
Input: nums = [12, 345, 2, 6, 7896]
Output: 2
Explanation:
12 → 2 digits ✅  
345 → 3 digits ❌  
2 → 1 digit ❌  
6 → 1 digit ❌  
7896 → 4 digits ✅  
✅ Final answer: 2

✅ Approach 1 — Count Digits with a Loop (Most Intuitive)
💡 Idea:
For each number:

Count how many digits it has (divide by 10 repeatedly)

Check if digit count is even

✅ Java Code:
java
Copy
Edit
public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        
        for (int num : nums) {
            int digits = 0;
            while (num != 0) {
                num = num / 10;
                digits++;
            }
            if (digits % 2 == 0) count++;
        }
        
        return count;
    }
}
✅ Approach 2 — Use String Length (Shortcut)
java
Copy
Edit
public int findNumbers(int[] nums) {
    int count = 0;
    for (int num : nums) {
        if (String.valueOf(num).length() % 2 == 0) {
            count++;
        }
    }
    return count;
}
Note: Less performant but readable.

✅ Approach 3 — Logarithmic Math (Fastest)
java
Copy
Edit
public int findNumbers(int[] nums) {
    int count = 0;
    for (int num : nums) {
        int digits = (int) Math.floor(Math.log10(num)) + 1;
        if (digits % 2 == 0) count++;
    }
    return count;
}
Logarithmic method is efficient when performance matters.

🔁 Dry Run:
yaml
Copy
Edit
nums = [12, 345, 2, 6, 7896]

12 → 2 digits → ✅
345 → 3 digits → ❌
2 → 1 digit → ❌
6 → 1 digit → ❌
7896 → 4 digits → ✅

Total: 2
🧠 Edge Cases:
[0] → has 1 digit → ❌

[100000] → 6 digits → ✅

📦 Time & Space Complexity
Metric	Value
Time	O(n × d) where d is number of digits in worst case
Space	O(1)
