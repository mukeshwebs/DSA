//single jumps
/*
NOTE:
direction array is used -> define dir array with the possible direction in which movements can be done
*/
    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dp, int[][] dir) {
        if (er == sr && ec == sc) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0) //memo
            return dp[sr][sc];

        int count = 0;   //store the counter to count the number of ways to reach to the end cell
        for (int[] d : dir) {     //we can make jumps in 3 directions , so it will traverse in each direction in which jump is going to happen
            int r = sr + d[0], c = sc + d[1];    //update the row and col by it's jump to new cell

          //check the boundry condition
            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {  
                count += mazePath_memo(r, c, er, ec, dp, dir);
            }
        }
        return dp[sr][sc] = count;
    }

    public static void mazePath() {
        int sr = 0, sc = 0, er = 3, ec = 3;
        int[][] dp = new int[er + 1][ec + 1];

        int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } }; //possible direction of jumps
        //Note: think the movement in terms of x and y in matrix -
        /*
        say if right movement is there then in matrix -> row = remain same, col = it will change
        down -> row = it will update, col= will remain same
         */
        System.out.println(mazePathJump_tabu(sr, sc, er, ec, dp, dir));

        display2D(dp);
    }

