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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findSumPath(root);
        return ans;
    }
    public int findSumPath(TreeNode root){
        if(root==null) return 0;
        int leftSum=Math.max(0,findSumPath(root.left));
        int rightSum=Math.max(0,findSumPath(root.right));
        int totalLevelSum=root.val+leftSum+rightSum;
        ans=Math.max(ans,totalLevelSum);
        return root.val+Math.max(leftSum,rightSum);
    }
}