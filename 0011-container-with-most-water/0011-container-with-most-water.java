class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j){
            if(height[i]<height[j]){
                int cw=height[i]*(j-i);
                max=Math.max(max,cw);
                i++;
            }else{
                 int cw=height[j]*(j-i);
                max=Math.max(max,cw);
                j--;
                
            }
        }
        return max;
    }
}