class Solution {
    public int numJewelsInStones(String jewels, String stones) {
       Set<Character> set = new HashSet<>();
       for(char s : jewels.toCharArray()){
            set.add(s);
       } 
       int count = 0;
       for(char c : stones.toCharArray()){
        if(set.contains(c)){
            count++;
        }
       }
       return count;
    }
}
 Time & Space Complexity:
Time: O(J + S), where J = jewels.length() and S = stones.length()

Space: O(J) — for the HashSet

✅ Core Concepts Practiced:
HashSet for quick lookup

Looping through characters

Counting based on membership
