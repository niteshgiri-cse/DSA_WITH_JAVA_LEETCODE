class Solution {
    public void helper(int index,int n,int k, List<Integer> output,List<List<Integer>>ans){
        if(output.size()==k){
            ans.add(new ArrayList<>(output));
            return;
        }
        for(int i=index;i<=n;i++){
            output.add(i);
            helper(i+1,n,k,output,ans);
            output.remove(output.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        int index=1;
        helper(index,n,k,output,ans);
        return ans;
    }
}