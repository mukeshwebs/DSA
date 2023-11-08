import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class l001 {
    public static Scanner scn = new Scanner(System.in);

    // ------------------------------ Printing Numbers ------------------------------

    public static void printDecreasing(int n) {
        if (n == 0)
            return;

        System.out.println(n);
        printDecreasing(n - 1);
    }

    public static void printIncreasing(int n) {
        if (n == 0)
            return;

        printIncreasing(n - 1);
        System.out.println(n);
    }

    public static void printEvenOdd(int n) {
        if (n == 0)
            return;

        if (n % 2 == 0)
            System.out.println(n);
        printEvenOdd(n - 1);
        if (n % 2 != 0)
            System.out.println(n);
    }

    // ------------------------------ Factorial and Power ------------------------------

    public static int factorial(int n) {
        return n == 0 ? 1 : factorial(n - 1) * n;
    }
 //gfg factorial
	
   class Solution{
    static long factorial(int N){
        // code here
        if(N<=1) return 1;
        
        long resAns = factorial(N-1);
        Long res = N*resAns;
        
        return res;
    }
}	

    public static int power(int a, int b) {
        return b == 0 ? 1 : power(a, b - 1) * a;
    }

    public static int power1(int a, int b) {
        if (b == 0)
            return 1;
        int smallAns = power(a, b - 1);
        return smallAns * a;
    }

    public static int powerBtr(int a, int b) {
        if (b == 0)
            return 1;
        int smallAns = powerBtr(a, b / 2);
        smallAns *= smallAns;
        return b % 2 != 0 ? smallAns * a : smallAns;
    }

    // ------------------------------ Array Operations ------------------------------

    public static void display(int[] arr, int idx) {
        if (idx == arr.length)
            return;

        System.out.println(arr[idx] + " ");
        display(arr, idx + 1);
    }

    public static int maximumEle(int[] arr, int idx) {
        if (idx == arr.length)
            return -(int) 1e9;
        return Math.max(arr[idx], maximumEle(arr, idx + 1));
    }
`````````````````````````````````````````````````
    public static int maxEle(int []arr, int idx){
       int max = Integer.MIN_VALUE;
       int res = 0;
        if(idx==arr.length) {
            return max;
        }
        max = maxEle(arr, idx+1);
        return Math.max(max, arr[idx]);
    }
`````````````````````````````````````````````````
    public static int minimumEle(int[] arr, int idx) {
        if (idx == arr.length)
            return (int) 1e9;
        return Math.min(arr[idx], minimumEle(arr, idx + 1));
    }

    public static int findData(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;
        if (arr[idx] == data)
            return idx;
        return findData(arr, idx + 1, data);
    }

    public static int findData2(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;
        int smallAns = findData2(arr, idx + 1, data);
        if (smallAns != -1)
            return smallAns;

        return arr[idx] == data ? idx : -1;
    }

    public static int[] allIndex(int[] arr, int idx, int count, int data) {
        if (idx == arr.length)
            return new int[count];
        if (arr[idx] == data)
            count++;
        int[] smallAns = allIndex(arr, idx + 1, count, data);
        if (arr[idx] == data)
            smallAns[count - 1] = idx;

        return smallAns;
    }

    // ------------------------------ String Operations ------------------------------

  //----------top to bottom appraoch----------
 //first we will make recursive call till the stack get's full and when base case break we return base.add(""); an empty list
 after that line below recursive call will make the answer. 
 The trick is when base case breaks the last ch will be the last element in string, let's say String is s = "abac"
 so ch = c when base case break and it will combine as a include and not include c so list will have [c, " "]
 in next iteration a will combine with all [c, " "] -> ["ac", "c",  "a", " "] similarly it will got for each iteration.

    public static ArrayList<String> subsequence(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(idx);

        ArrayList<String> smallAns = subsequence(str, idx + 1);
        ArrayList<String> myAns = new ArrayList<>();

        for (String s : smallAns) {
            myAns.add(s); //not add the current element 
            myAns.add(ch + s);  //add the current element	
        }
        return myAns;
    }

  //----------bottom to top approach----------
  //making answers on the way
  
  public class printSubsequence {
	/*
	 * ques, ans
	 */
	public static void printSS(String ques, String ans) {
		//base case - agr question ki len zero ho jaaye 
		if(ques.length()==0) 
		{
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);  //abc -> ch = a
		String roq = ques.substring(1); // bc
		printSS(roq, ans+ch);   //taking the a -> ans a ho gya aur ques is "bc"
		printSS(roq, ans+"");   //not taking the a->means ans me kuch nhi jaayega 
		
	}
	public static void main(String [] args) {
		String ques = "abc";
		String ans = "";
		
		printSS(ques, ans);
	}
}

    // ------------------------------ Keypad Combinations ------------------------------

  //----------bottom to top ----------
  //ref - sumit sir video (https://www.youtube.com/watch?v=3fjt19bjs3A&t=655s&ab_channel=Pepcoding)
  //making answers on the way
  - qsf, asf -> 
	
public class printKpc {
    public static void main(String[] args) {
        String ques = "234";
        printKpc(ques, "");
    }
    public static void printKpc(String ques, String ans) {
        String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        // Base case
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        // Recursive call
        char ch = ques.charAt(0);  
        String roq = ques.substring(1);
        
        String codeforch = codes[ch - '0']; 
        
        // Traverse and add char
        for (int i = 0; i < codeforch.length(); i++) {
            char cho = codeforch.charAt(i);
            printKpc(roq, ans + cho);
        }
    }
}
	
/----Rajneesh-----
  
    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz", "+-*", "/%^" };

    public static ArrayList<String> getKPC(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        int indexOfCode = str.charAt(idx) - '0';

        ArrayList<String> smallAns = getKPC(str, idx + 1);
        ArrayList<String> myAns = new ArrayList<>();

        String code = codes[indexOfCode];
        for (int i = 0; i < code.length(); i++) {
            for (String s : smallAns) {
                myAns.add(code.charAt(i) + s);
            }
        }

        return myAns;
    }
//----leetcode-----
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

    // ------------------------------ Decode Ways ------------------------------

    public static int decodeWays(String str, int idx, String ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return 1;
        }

        if (str.charAt(idx) == '0')
            return 0;

        int count = 0;
        count += decodeWays(str, idx + 1, ans + (char) (str.charAt(idx) - '1' + 'a'));
        if (idx < str.length() - 1) {
            int num = (str.charAt(idx) - '0') * 10 + (str.charAt(idx + 1) - '0');
            if (num <= 26) {
                count += decodeWays(str, idx + 1, ans + (char) (num - 1 + 'a'));
            }
        }

        return count;
    }

    public int decodeWays(String str, int idx) {
        if (idx == str.length()) {
            return 1;
        }

        if (str.charAt(idx) == '0')
            return 0;

        int count = 0;
        count += decodeWays(str, idx + 1);

        if (idx < str.length() - 1) {
            int num = (str.charAt(idx) - '0') * 10 + (str.charAt(idx + 1) - '0');
            if (num <= 26) {
                count += decodeWays(str, idx + 2);
            }
        }

        return count;
    }

    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        return decodeWays(s, 0);
    }

    // ------------------------------ Permutations ------------------------------

    public static int printPermutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1); // ros: rest of the string
            count += printPermutations(ros, ans + ch);
        }

        return count;
    }

    public static int printPermutationUnique(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        boolean[] vis = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!vis[ch - 'a']) {
                vis[ch - 'a'] = true;
                String ros = str.substring(0, i) + str.substring(i + 1); // ros: rest of the string
                count += printPermutationUnique(ros, ans + ch);
            }
        }

        return count;
    }

    public static void printPermutationUnique() {
        String str = "aba";
        printPermutationUnique(str, "");
    }

    public static void main(String[] args) {
        printDecreasing(10);
    }
}
