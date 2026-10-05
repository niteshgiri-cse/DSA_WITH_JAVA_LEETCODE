class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        int [] visited=new int[nums.length];
        helper(nums,visited,output,ans);
        return ans;
    }
    public void helper(int[]nums,int[] visited,List<Integer> output,List<List<Integer>> ans){
        if(output.size()==nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                output.add(nums[i]);
                visited[i]=1;
                helper(nums,visited,output,ans);
                output.remove(output.size()-1);
                visited[i]=0;
            }
        }
    }
}