 Intuition:
Count frequency of characters in magazine.

For each character in ransomNote, check if it exists in magazine with enough frequency.

If not → return false.

✅ Java Solution using HashMap:
java
Copy
Edit
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each character in magazine
        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: For each character in ransomNote, check and reduce
        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false; // Not enough of this character
            }
            map.put(ch, map.get(ch) - 1); // Use one occurrence
        }

        return true;
    }
}
🔍 Example Dry Run:
java
Copy
Edit
ransomNote = "aab"
magazine = "baa"

magazine map: {b:1, a:2}

Check 'a' → exists → use 1 → a:1  
Check 'a' → exists → use 1 → a:0  
Check 'b' → exists → use 1 → b:0  

✅ All passed → return true
🧠 Core Java Concepts Practiced:
HashMap<Character, Integer>

getOrDefault(key, defaultValue)

put(key, value)

containsKey(key)

⏱ Time & Space Complexity:
Time: O(n + m) — n = length of ransomNote, m = length of magazine

Space: O(1) — At most 26 lowercase letters

💡 Follow-up Variants:
❓ What if letters were case-sensitive?

❓ What if magazine can be used multiple times?
