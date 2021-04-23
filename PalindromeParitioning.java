import java.util.*;
import java.io.*;

public class PalindromeParitioning {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        boolean[][] dp = new boolean[str.length()][str.length()];
        for(int g = 0;g<str.length(); g++){
            for(int i = 0, j = g;j<dp[0].length; i++,j++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true;
                    }
                }else{
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        System.out.println(palindromePartRecursive(str, dp, str.length()-1, str.length()-1));
        System.out.println(palindromePartMemo(str, dp, new Integer[str.length()], str.length()-1, str.length()-1));
        System.out.println(minPalindromicCut(str, dp));
    }
    public static int palindromePartRecursive(String str, boolean[][] dp, int i, int j){
        if(i == 0 || j == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = j;k>=0; k--){
            if(dp[k][j]){
                int cut = palindromePartRecursive(str, dp, k-1, k-1);
                if(k == 0){
                    return 0;
                }else{
                    if(min>cut){
                        min = cut;
                    }
                }
            }
        }
        return min+1;
    }

    public static int palindromePartMemo(String str, boolean[][] pal, Integer[] dp, int i, int j){
        if(i == 0 || j == 0){
            return 0;
        }
        if(pal[0][j]){
            dp[j] = 0;
        }else{
            int min = Integer.MAX_VALUE;
            for(int k = j;k>=0; k--){
                if(pal[k][j]){
                    if(dp[j] == null){
                        int cut = palindromePartMemo(str, pal, dp, k-1, k-1);
                        if(cut<min){
                            min = cut;
                        }
                    }else{
                        if(min>dp[j]){
                            min = dp[j];
                        }
                    }
                }
            }
            dp[j] = min+1;
        }
        return dp[j];
        
    }

    public static int minPalindromicCut(String s, boolean[][] dp){
        int[] dp1 = new int[s.length()];
        dp1[0] = 0;
        for(int j = 1;j<s.length(); j++){
            if(dp[0][j]){
                dp1[j] = 0;
            }else{
                int min = Integer.MAX_VALUE;
                for(int i = j;i>=0; i--){
                    if(dp[i][j]){
                        int val = dp1[i-1];
                        if(val<min){
                            min = val;
                        }
                    }
                }
                dp1[j] = min+1;
            }
            
        }
        return dp1[s.length()-1];
	}

}
