class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length];
        int ans = 0;
        for (int fruit : fruits) {
            boolean placed = false;
            for (int i = 0; i < baskets.length; i++) {
                if (!used[i] && baskets[i] >= fruit) {
                    used[i] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed)
                ans++;
        }
        return ans;
    }
}