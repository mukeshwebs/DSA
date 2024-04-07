https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

package Dynamic_Programming;

public class partition_set_into_k_subset {
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        System.out.println(noOfWays(n, k));
    }

    static int noOfWays(int n, int k){
     int [][]dp = new int[n+1][k+1];
     return noOfWays(n, k,dp);
    }
    public static int noOfWays(int n, int k, int[][]dp){
        //if only one team is there the all players will have to
        // form one team & noOfWays will be 1
        if(k==1){
            return dp[n][k] = 1;
        }
        //if number of team and players are same 
        if(n==k){
            return dp[n][k] = 1;
        }
        if(dp[n][k]!=0){
            return dp[n][k];
        }
        int unique = noOfWays(n-1, k-1, dp);
        //multiplied by k bcz if a player want to form team with other player he can be with 
        //them in any of the team other player can form as other player can form k team so multiplied by k
        int partOfExistingTeam = noOfWays(n-1, k, dp)*k;
     return dp[n][k]= unique+partOfExistingTeam;
    }
}
