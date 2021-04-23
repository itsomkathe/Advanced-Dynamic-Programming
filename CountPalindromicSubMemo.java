import java.util.*;
import java.io.*;

public class CountPalindromicSubMemo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        System.out.println(CPS(str, 0, str.length()-1, new int[str.length()][str.length()]));
    }
    
    public static int CPS(String str, int i, int j, int[][] dp){
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
            int count = CPS(str, i, j-1, dp) + CPS(str, i+1, j, dp) +1;
            dp[i][j] = count;
            return count;
        }else{
            int count = CPS(str, i, j-1, dp) + CPS(str, i+1, j, dp) - CPS(str, i+1, j-1, dp);
            dp[i][j] = count;
            return count;
        }
    }
}
