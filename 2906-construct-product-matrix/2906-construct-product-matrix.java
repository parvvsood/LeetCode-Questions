class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int[][] ans = new int[n][m];
        long prefix = 1;
        // Product of all elements before current cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int) prefix;
                prefix = (prefix * grid[i][j]) % mod;
            }
        }
        long suffix = 1;
        // Product of all elements after current cell
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                ans[i][j] = (int) ((ans[i][j] * suffix) % mod);
                suffix = (suffix * grid[i][j]) % mod;
            }
        }
        return ans;
    }
}