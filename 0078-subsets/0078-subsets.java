class Solution {
    public void helper(int[] nums,int index,List<Integer> output, List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }
        output.add(nums[index]);
        helper(nums,index+1,output,ans);
        output.remove(output.size()-1);
        helper(nums,index+1,output,ans);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        int index=0;
        helper(nums,index,output,ans);
        return ans;

    }
}