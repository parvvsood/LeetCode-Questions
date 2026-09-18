class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } 
            else {
                int index = (i + nums[i]) % n;
                if (index < 0) {
                    index += n;
                }
                result[i] = nums[index];
            }
        }
        return result;
    }
}