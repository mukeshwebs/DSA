https://leetcode.com/problems/distinct-subsequences/description/
/*
Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:
*/

Time Complexity: O(n * m)
Space Complexity: O(n * m)

time complexity is O(n * m), where n is the length of string s and m is the length of string t
  
The space complexity is determined by the size of the memoization table. 
The memoization table dp has dimensions (n + 1) x (m + 1). Therefore, the space complexity is O(n * m) as well. 


//memoization
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(); // String s ki length
        int m = t.length(); // String t ki length
        int [][]dp = new int[n+1][m+1]; // 2D array dp jisme hum store karenge subproblems ka solution
        for(int []d: dp){
            Arrays.fill(d, -1); // dp array ko -1 se fill karo initially
        }
        return numDistinct_dp(s, t, n, m, dp); // numDistinct_dp function ko call karo
    }

    public int numDistinct_dp(String s, String t, int n, int m, int[][]dp){
        // Base case
        if(m==0){
            return dp[n][m] = 1; // agar t ki length 0 hai toh ek hi tarika hai, khud ko select karo
        }
        if(n<m) return dp[n][m] = 0; // agar s ki length t se choti hai toh koi subsequence nahi ban sakta

        // Memoization
        if(dp[n][m]!=-1){
            return dp[n][m]; // agar subproblem solve ho chuka hai toh uska solution return karo
        }

        // Agar dono character match karte hain toh do possibilities hain
        /*
        rabbbit/rabbit - > abbbit/abbit : aage se 'abbit' ko string s mei find karenge
        doosri possibility hai t ko next index se string s mei find karna
        Kyunki aisa bhi ho sakta hai ki next index se mil jaye.

        rabbbit/rabbit ->  abbbit/rabbit

        */
        if(s.charAt(n-1)==t.charAt(m-1)){
            int a = numDistinct_dp(s, t,n-1, m-1, dp); // match ho gaya toh dono ko aage badha ke check kro
            int b = numDistinct_dp(s, t,n-1, m, dp); // agr match hua to ek possibislities hai ki t ki string s me current char ke baad bhi mil skti hai
            //ex : s = abgbag, t =bag
            /*
             rec call a -> bgbag/ag -> ag ko s me search kro
             rec call b->  bgbag/bag -> t s me next index se bhi khi mil skti hai to wi possibility explore kro
             */
            return dp[n][m] = a+b; // dono possibilities ka sum return karo
        }else{
            int b = numDistinct_dp(s, t,n-1, m, dp); // agar character match nahi hua toh next index se t ko find karne ke liye recursive call karo
            return dp[n][m] = b; // sirf ek hi possibility hai is case mei
        }
    }
}

