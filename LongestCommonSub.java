import java.util.*;
import java.io.*;

public class LongestCommonSub {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = dp.length-1;i>=0; i--){
            for(int j = dp[0].length-1;j>=0; j--){
                if(i == dp.length-1 || j == dp[0].length-1){
                    dp[i][j] = 0;
                }else{
                    if(str1.charAt(i) == str2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
