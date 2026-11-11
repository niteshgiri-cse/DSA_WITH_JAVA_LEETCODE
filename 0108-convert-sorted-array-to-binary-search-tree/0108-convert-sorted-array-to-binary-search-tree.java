
class Solution {

    public TreeNode helper(int[] nums, int st, int end) {

        // Base case
        if (st > end) {
            return null;
        }

        // Find middle element
        int mid = st + (end - st) / 2;

        // Create root node
        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree
        root.left = helper(nums, st, mid - 1);

        // Build right subtree
        root.right = helper(nums, mid + 1, end);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }
}
