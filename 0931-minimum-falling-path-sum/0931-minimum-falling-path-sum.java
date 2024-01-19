class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int rows = matrix.length;
        int cols = matrix[0].length;
        Integer[][] dp = new Integer[rows + 1][cols + 1];
        int minsteps = Integer.MAX_VALUE; // Initialize to a large value

        for (int i = 0; i < cols; i++) {
            minsteps = Math.min(minsteps, helper(matrix, 0, i, dp));
        }

        return minsteps;
    }

    int helper(int[][] matrix, int row, int col, Integer[][] dp) {
    // handling the base cases
     if (row == matrix.length) {
        return 0;
    }
    //we reached a path that is not reachable
    if (col < 0 || col >= matrix[0].length) {
        return Integer.MAX_VALUE;
    }

    if (dp[row][col] != null) {
        return dp[row][col];
    }

    int minsteps = matrix[row][col] + Math.min(
            helper(matrix, row + 1, col - 1, dp),
            Math.min(helper(matrix, row + 1, col, dp), helper(matrix, row + 1, col + 1, dp))
    );
    dp[row][col] = minsteps;

    return minsteps;
}
}