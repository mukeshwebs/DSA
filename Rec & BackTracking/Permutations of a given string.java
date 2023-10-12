https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


class Solution {
    public List<String> find_permutation(String S) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<String>();
        find_permutationHelper(S, "", res, set);
        Collections.sort(res); //lexicographically sorted order
        return res;
    }
    public static void find_permutationHelper(String str, String ans, List<String> res, HashSet<String> set) {
        // Base case
        if (str.length() == 0) {
            if(!set.contains(ans)){ //[abc, ]
                set.add(ans);
                res.add(ans);// [abc, ]
                return;        
            }
        }
        // ex: abcdef , ch = d
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);   // abcdef , ch = d
            String ros = str.substring(0, i) + str.substring(i + 1); //abc+ef
            find_permutationHelper(ros, ans + ch, res, set); //making answers on the way by adding ch in ans
        }
    }
}
