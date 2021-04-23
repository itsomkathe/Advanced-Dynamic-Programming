import java.util.*;
import java.io.*;

public class LongestPalindromicSubMemo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        System.out.println(LPS(str, 0, str.length()-1,new int[str.length()][str.length()]));

    }
    public static int LPS(String str, int i, int j, int[][] dp){
        if(i>j){
            return 0;
        }
        if(i == j){
            return 1;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(str.charAt(i) == str.charAt(j)){
            int lps = LPS(str, i+1, j-1, dp) + 2;
            dp[i][j] = lps;
            return lps;
        }else{
            int lps = Math.max(LPS(str, i, j-1, dp), LPS(str, i+1, j, dp));
            dp[i][j] = lps;
            return lps;
        }
    }
}
