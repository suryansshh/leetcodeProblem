class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length; 
        int col = grid[0].length; 
        int memo[][][] = new int[row][col][col] ; 

        for(int i = 0 ;i< row ;i++)
        {
            for(int j =0 ;j < col ;j++)
            {
                for(int k = 0 ;k < col ;k++)
                {
                    memo[i][j][k] = Integer.MIN_VALUE; 
                }
            }
        }
        return fun( grid, 0,0, grid[0].length -1, memo);
    }

    public int fun(int[][] grid , int i , int j1 , int j2, int memo[][][])
    {
        if(i < 0 || i>= grid.length || j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length)
        {
            return Integer.MIN_VALUE; 
        }
        if( i == grid.length -1)
        {
            if( j1 == j2 )
            {
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2]; 
        }
        if( memo[i][j1][j2] != Integer.MIN_VALUE)
        {
            return memo[i][j1][j2]; 
        }
        int max = Integer.MIN_VALUE; 
        for(int x = -1 ; x<= 1 ;x++)
        {
            for(int y = -1 ; y<= 1 ;y++)
            {
                int val =0  ;
                if( j1 == j2)
                {
                    val = grid[i][j1]; 
                }
                else{
                    val = grid[i][j1] + grid[i][j2]; 
                }
                max = Math.max( max , val + fun(grid, i+1 ,j1 + x, j2+ y, memo)); 
            }
        }
        return memo[i][j1][j2] = max; 


    }
}