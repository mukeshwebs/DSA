https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

//direction array logic used here

class Solution {
    public static int floodFill(int sr, int sc, int[][] vis, String psf, ArrayList<String> res, int[][] dir, String[] dirs) {
        int n = vis.length, m = vis[0].length;
        if (sr == n - 1 && sc == m - 1) { 
            res.add(psf);
            return 1; //1 path is found so return 1
        }
        int count = 0; // Initialize count to 0
        vis[sr][sc] = 0; // Block the cell
        // Neighbors
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if (r >= 0 && c >= 0 && r < n && c < m && vis[r][c] == 1) {
                count += floodFill(r, c, vis, psf + dirs[d], res, dir, dirs);
            }
        }
        vis[sr][sc] = 1; // Unblock the cell
        return count; // Return the count of paths
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        String[] dirs = {"D", "L", "R", "U"};
        ArrayList<String> res = new ArrayList<String>();
        
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return res; // Return an empty list if the start or end cell is blocked
        }
        
        int count = floodFill(0, 0, m, "", res, dir, dirs);
        return res;
    }
}
