import java.util.*;
import java.io.*;

public class MinCostStringIdentical {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String s1 = br.readLine();
        String s2 = br.readLine();
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        System.out.println(solution(s1, s2, x, y));
    }

    public static int solution(String s1, String s2, int c1, int c2) {
        // write your code here
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = dp.length-1;i>=0; i--){
            for(int j = dp[0].length-1;j>=0; j--){
                if(i == dp.length-1 || j == dp[0].length-1){
                    dp[i][j] = 0;
                }else{
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
        }
        int lcs = dp[0][0];
        int a = s1.length() - lcs;
        int b = s2.length() - lcs;
        int cost = a*c1 + b*c2;
        return cost;
    }
}
