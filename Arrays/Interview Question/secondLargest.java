class Solution{
  public int secLargest(int nums[]){
    int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
    for(int num: nums){
      if(num>max){
        second = max;
        max = num;
      }else if(num>second && num != max)
      {
        second = num;
      }
    }
    return second;
  }
}
