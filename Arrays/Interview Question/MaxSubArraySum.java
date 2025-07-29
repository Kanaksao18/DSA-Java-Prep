int maxSum = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;

//tc: O(n) sc: 1
