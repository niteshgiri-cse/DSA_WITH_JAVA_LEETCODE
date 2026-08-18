class Solution {
    public int singleNonDuplicate(int[] nums) {
      int output=0;
      for(int i=0;i<nums.length;i++){
        output^=nums[i];
      }


    return output;
    }
}