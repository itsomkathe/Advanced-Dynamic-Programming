import java.util.*;
import java.io.*;

public class RodCuttingMemo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int[] arr = new int[n+1];
        for(int i = 0;i<n; i++){
            arr[i+1] = Integer.parseInt(sarr[i]);
        }
        System.out.println(rodCutting1(n, arr, new Integer[n+1]));
    }
    public static int rodCutting1(int n, int[] arr, Integer[] dp){
        if(n == 0 || n == 1){
            return arr[n];
        }
        if(dp[n] != null){
            return dp[n];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n; i++){
            int prevOpt = rodCutting1(n-i, arr, dp);
            int myMax = prevOpt + arr[i];
            if(myMax>max){
                max = myMax;
            }
        }
        dp[n] = max;
        return max;
    }
}
