class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){
            if(buyPrice < prices[i]){
                profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
// Optimal Solution — Greedy + Two Pointer (O(n))
// 💡 Idea:
// Keep track of the minimum price so far

// At each step, compute the profit: prices[i] - minPrice

// Keep track of the maximum profit
//  Time and Space Complexity
// Metric	Value
// Time	O(n)
// Space	O(1)
