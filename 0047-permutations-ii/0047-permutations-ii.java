class Solution {
    public void helper(int[] nums,boolean[] visited,List<Integer> output,List<List<Integer>>ans){
        if(output.size()==nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            visited[i]=true;
            output.add(nums[i]);
            helper(nums,visited,output,ans);
            output.remove(output.size()-1);
            visited[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        boolean [] used=new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums,used,output,ans);
        return ans;
    }
}