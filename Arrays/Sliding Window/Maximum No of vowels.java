 Key Concept: Sliding Window
We keep a window of size k, slide it across the string, and track the number of vowels in the current window. Update the maximum as we go.

✅ Java Code:
java
Copy
Edit
class Solution {
    public int maxVowels(String s, int k) {
        int max = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add right char
            if (isVowel(s.charAt(i))) count++;

            // Remove left char if window is bigger than k
            if (i >= k && isVowel(s.charAt(i - k))) count--;

            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
🔍 Dry Run
Input:
java
Copy
Edit
s = "abciiidef", k = 3
i	Char	Is Vowel?	Count	Window	Max
0	'a'	✅	1	"a"	1
1	'b'	❌	1	"ab"	1
2	'c'	❌	1	"abc"	1
3	'i'	✅	2	"bci"	2
4	'i'	✅	2	"cii"	2
5	'i'	✅	3	"iii"	3 ✅
6	'd'	❌	2	"iid"	3
7	'e'	✅	2	"ide"	3
8	'f'	❌	1	"def"	3

✅ Output: 3

🧪 Edge Test Case:
java
Copy
Edit
s = "aeiou", k = 2 → Output = 2
s = "leetcode", k = 3 → Output = 2
s = "rhythms", k = 4 → Output = 0
🕒 Complexity:
Time: O(n) – loop through string once

Space: O(1) – only constant space used

