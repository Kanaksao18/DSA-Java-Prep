class Solution{
  public int maxElemnt(int arr[]){
    int max = arr[0];
    for(int num: arr){
      if(num>max){
        max = num;
      }
    }
    return max;
  }
      
}
