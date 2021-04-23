import java.util.*;
import java.io.*;

public class LongestPalindromicSub {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();

        int[][] dp = new int[str.length()][str.length()];

        for(int g = 0;g<str.length();g++){

            for(int i = 0,j = g;j<dp.length; i++,j++){
                if(g == 0){
                    dp[i][j] = 1;
                }else if(g == 1){
                    dp[i][j] = str.charAt(i) == str.charAt(j)?2:1;
                }else{
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }

        System.out.println(dp[0][dp.length-1]);
    }


}
