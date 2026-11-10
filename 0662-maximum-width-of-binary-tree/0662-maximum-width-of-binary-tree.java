/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode root,int index){
            this.node=root;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int cnt=q.size();
            int minIndex=q.peek().index;
            int maxIndex=0;
            for(int i=0;i<cnt;i++){
                Pair curr=q.poll();
                TreeNode currNode=curr.node;
                int currIndex=curr.index;
                if(currNode.left!=null) q.offer(new Pair(currNode.left,2*currIndex+1));
                if(currNode.right!=null) q.offer(new Pair(currNode.right,2*currIndex+2));
                if(i==cnt-1){
                    maxIndex=currIndex;
                }
            }
            int currWidth=maxIndex-minIndex+1;
            ans=Math.max(ans,currWidth);
        }
        return ans;
    }
}