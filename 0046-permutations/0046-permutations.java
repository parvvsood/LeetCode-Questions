import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int[] nums, boolean[] visited,
                          List<Integer> curr,
                          List<List<Integer>> ans) {

        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            curr.add(nums[i]);
            backtrack(nums, visited, curr, ans);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}