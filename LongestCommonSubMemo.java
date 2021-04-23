import java.util.*;
import java.io.*;

public class LongestCommonSubMemo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(LCS(str1, str2,0,0, new Integer[str1.length()+1][str2.length()+1]));
    }

    public static int LCS(String s1, String s2,int i, int j, Integer[][] dp){
        if(i == s1.length() || j == s2.length()){
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int myLCS = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            int prevLCS = LCS(s1, s2, i+1, j+1, dp);
            myLCS = prevLCS + 1;
        }else{
            int prevLCS = Math.max(LCS(s1, s2, i+1, j, dp), LCS(s1, s2, i, j+1, dp));
            myLCS = prevLCS;
        }
        dp[i][j] = myLCS;
        return myLCS;
    }
}
