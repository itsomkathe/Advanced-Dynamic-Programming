import java.util.*;
import java.io.*;

public class LongestIncreasingSub {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int[] dp = new int[n];

        for(int i = 0;i<n; i++){
            int lmax = 0;
            for(int j = 0;j<i; j++){
                if(arr[j]<arr[i]){
                    if(dp[j]>lmax){
                        lmax = dp[j];
                    }
                }
            }
            dp[i] = lmax+1;
            if(dp[i]>max){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}