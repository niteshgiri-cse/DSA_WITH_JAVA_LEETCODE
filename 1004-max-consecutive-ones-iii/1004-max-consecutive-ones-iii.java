class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int ans=0;
        int currSum=0;
        for(int right=0;right<n;right++){
            currSum+=nums[right];
            while(currSum+k<right-left+1){
                currSum-=nums[left];
                left++;
            }
            ans=Math.max(ans,right-left+1);

        }
        return ans;
    }
}