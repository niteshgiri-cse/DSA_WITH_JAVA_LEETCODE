class Solution {
    public int[] twoSum(int[] nums, int target) {
        int st=0;
        int end=nums.length-1;
        while(st<end){
            int sum=nums[st]+nums[end];
            if(sum==target){
                return new int[]{st+1,end+1};
            }else if(sum>target){
                end--;
            }else st++;
        }
        return new int []{};
    }
}