https://leetcode.com/problems/letter-combinations-of-a-phone-number/

S = "573"
split it in ch = "5" and ros = "73"

  when ros becomes empty return an empty list and in that one letter ref 3 will combine with rec result as rec result will return " " so 3 refernce is def so d will combine
  first then 3 then f similarly all will combine and make the result
  ---ch------ros--- 
  |      |       |
  | 3    |   " " |
  |      |       |
  | 7    |  3    |
  |      |       |
  | 5    | 73    |
  ----------------

//stack 
  

class Solution {
    String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        List<String> res = CombinationsHelper(digits);
        return res;
    }
    //578
    public List<String> CombinationsHelper(String ques){
        if(ques.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = ques.charAt(0); //5
        String ros = ques.substring(1);  // 78

        List<String> rres = CombinationsHelper(ros); //recursion result 
        List<String> myres = new ArrayList<>();
        
        String codeCh = key[ch-'0'];
        for(int i=0; i<codeCh.length(); i++){
            char temp = codeCh.charAt(i);
            for(String num: rres){ // ["ab", "bc"]
                myres.add(temp+num);
            }
        }
        return myres;
    }
} 
