import java.util.*;
import java.io.*;

public class CatalanNumber {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i<dp.length; i++){
            for(int j = 0;j<i; j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[n]);
    }
}
