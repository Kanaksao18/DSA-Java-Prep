class Solution{
  public int find(int nums){
    int n = nums.length;
    int totalSum = 0;
    for(int num: nums){
      totalSum+=num;
    }
    int leftSum = 0;
    for(int i = 0; i < n; i++){
      int rightSum = totalSum - leftSum - nums[i];
      if(rightSum = leftSum){
        return i;
      }
      leftSum+= nums[i];
    }
    return -1;
  }
}
 Time and Space Complexity
Metric	Value
Time	O(n)
Space	O(1)
