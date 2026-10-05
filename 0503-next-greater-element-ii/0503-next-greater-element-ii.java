import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // Initially, no next greater element
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        Stack<Integer> st = new Stack<>();
        // Traverse the array twice because it is circular
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            // Remove elements that cannot be the answer
            while (!st.isEmpty() && st.peek() <= nums[index]) {
                st.pop();
            }
            // Only fill answer during the first traversal
            if (i < n) {
                if (!st.isEmpty()) {
                    ans[index] = st.peek();
                }
            }
            // Put current element into stack
            st.push(nums[index]);
        }
        return ans;
    }

}