class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int nsr[] = new int[heights.length];
        int nsl[] = new int[heights.length];

        //next smaller right
        Stack<Integer> s = new Stack<>();

        for(int i = heights.length-1; i>=0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                //-1
                nsr[i] = heights.length;


            }else{
                //top
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //next samallest left
       s = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                //-1
                nsl[i] = -1;


            }else{
                //top
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //current area

        for(int i = 0; i <heights.length; i++){
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
        
    }
}
