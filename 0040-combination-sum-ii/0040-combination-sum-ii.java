class Solution {
    public void helper(int [] candidates,int idx,List<Integer> curr,int target,List<List<Integer>> ans){

        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            curr.add(candidates[i]);
           helper(candidates, i + 1, curr, target - candidates[i], ans);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,0,new ArrayList<>(),target,ans);
        return ans;
    }
}