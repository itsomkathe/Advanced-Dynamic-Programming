import java.util.*;
import java.io.*;

public class RodCutting {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int[] prices = new int[n];
        for(int i = 0;i<n; i++){
            prices[i] = Integer.parseInt(sarr[i]);
        }
        System.out.println(solution(prices));
        br.close();
    }
    public static int solution(int[] prices){
        int[] arr = new int[prices.length+1];
        for(int i = 0;i<prices.length; i++){
            arr[i+1] = prices[i];
        }
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = arr[1];
        for(int i = 2;i<dp.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1;j<=i; j++){
                int val = arr[j] + dp[i-j];
                if(val>max){
                    max = val;
                }
            }
            dp[i] = max;
        }
        return dp[dp.length-1];
    }
    
}
