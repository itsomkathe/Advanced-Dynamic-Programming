import java.util.*;
import java.io.*;

public class MaximumSumIncSub {
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

        Integer max = Integer.MIN_VALUE;
        Integer[] dp = new Integer[n];

        for(int i = 0;i<n; i++){
            Integer lmax = null;
            for(int j = 0;j<i; j++){
                if(arr[j]<=arr[i]){
                    if(lmax == null){
                        lmax = dp[j];
                    }else if(lmax<dp[j]){
                        lmax = dp[j];
                    }
                }
            }
            if(lmax == null){
                dp[i] = arr[i];
            }else{
                dp[i] = arr[i] + lmax;
            }

            if(dp[i]>max){
                max = dp[i];
            }
        }
        System.out.println(max);
    }

}

