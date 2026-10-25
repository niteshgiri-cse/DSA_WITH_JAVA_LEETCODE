class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        boolean [] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(i,visited,adj);
                count++;
            }
        }
        return count;

    }
    public void bfs(int i,boolean[] visited,int[][] adj){
        int n=adj.length;
        visited[i]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front=q.remove();
            for(int j=0;j<n;j++){
                if(adj[front][j]==1 && !visited[j]){
                    q.add(j);
                    visited[j]=true;
                }
            }
        }
    }

}