import java.util.*;
import java.io.*;

public class MaxSquare {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j*j<=i; j++){
                int rem = i - (j*j);
                if(dp[rem]<min){
                    min = dp[rem];
                }
            }
            dp[i] = min+1;
        }

        return dp[n];
    }
}
