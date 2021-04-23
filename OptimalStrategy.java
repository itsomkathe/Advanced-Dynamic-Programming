import java.util.*;
import java.io.*;

public class OptimalStrategy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] sarr = br.readLine().split(" ");
        for(int i = 0;i<n; i++){
            arr[i] = Integer.parseInt(sarr[i]);
        }
        optimalStrategy(arr);
        br.close();
    }

    public static void optimalStrategy(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int g = 0;g<n; g++){
            for(int i = 0,j = g;j<n; i++,j++){
                if(g == 0){
                    dp[i][j] = arr[i];
                }else if(g == 1){
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }else{
                     int fc = arr[i] + Math.min(dp[i+1][j-1], dp[i+2][j]);
                     int lc = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                     dp[i][j] = Math.max(fc, lc);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
