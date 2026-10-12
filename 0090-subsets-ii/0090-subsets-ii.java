
import java.util.*;

class Solution {
    public void helper(int[] nums, int index,
                       List<Integer> output,
                       List<List<Integer>> ans) {

        ans.add(new ArrayList<>(output));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            output.add(nums[i]);
            helper(nums, i + 1, output, ans);
            output.remove(output.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        helper(nums, 0, output, ans);

        return ans;
    }
}
