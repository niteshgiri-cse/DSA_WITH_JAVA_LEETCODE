class Solution {
    public String getPermutation(int n, int k) {
         int [] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        int [] visited=new int[n+1];
        ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
        ArrayList<Integer> output=new ArrayList<>();
        int index=1;
        helper(arr,index,visited,output,ans);
        String res="";
        for(int i=0;i<ans.get(k-1).size();i++){
            res+=ans.get(k-1).get(i);
        }
        return res;
    }
    public void helper(int[] arr,int index,int[] visited,ArrayList<Integer> output,ArrayList<ArrayList<Integer>> ans){
        if(index>arr.length){
            ans.add(new ArrayList<>(output));
            return;
        }
        for(int i=0;i<arr.length;i++){
        if(visited[i]==0){
            visited[i]=1;
            output.add(arr[i]);
            helper(arr,index+1,visited,output,ans);
            output.remove(output.size()-1);
            visited[i]=0;
            }
        }

    }
}