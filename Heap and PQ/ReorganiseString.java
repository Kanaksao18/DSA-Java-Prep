class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max Heap: store [char, frequency]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        // Add all characters with non-zero frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] { i, freq[i] });
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = null; // store last used char

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            result.append((char)(curr[0] + 'a'));
            curr[1]--;

            // Add the previous character back if it still has frequency
            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }

            // Set current char as previous for next round
            prev = curr;
        }

        // Check if valid result
        return result.length() == s.length() ? result.toString() : "";
    }
}
// 🔍 Core Idea:
// We need to rearrange characters so that no two adjacent characters are the same.

// First, count frequency of each character.

// Use a max heap to always pick the character with the highest remaining frequency, so we space them out.

// Use a greedy approach: Always pick the most frequent character not used in the previous step.

// 💡 Why Max Heap?
// Because we want to pick the character with highest frequency left (and not used last), so we can maximize distance between same characters.

// 📊 Time and Space Complexity:
// Aspect	Complexity
// Time Complexity	O(N log 26) ≈ O(N)
// Space Complexity	O(26) ≈ O(1) (only lowercase letters)
