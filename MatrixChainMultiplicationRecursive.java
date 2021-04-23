import java.util.*;
import java.io.*;

public class MatrixChainMultiplicationRecursive {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String[] sarr = br.readLine().split(" ");
        int[] arr = new int[sarr.length];
        for(int i = 0;i<sarr.length; i++){
            arr[i] = Integer.parseInt(sarr[i]);
        }
        System.out.println(MCMRecursive(arr, 0, arr.length-2));

    }

    public static int MCMRecursive(int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<j; k++){
            int prev1 = MCMRecursive(arr, i, k);
            int prev2 = MCMRecursive(arr, k+1, j);
            int myCost = (arr[i]*arr[k+1]*arr[j+1])+prev1+prev2;
            if(myCost<min){
                min = myCost;
            }
        }
        return min;
    }

    public static int MCMMemoization(int[] arr, int i, int j, Integer[][] dp){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<j; k++){
            int prev1 = MCMMemoization(arr, i, k, dp);
            int prev2 = MCMMemoization(arr, k+1, j, dp);
            int myCost = (arr[i]*arr[k+1]*arr[j+1])+prev1+prev2;
            if(myCost<min){
                min = myCost;
            }
        }
        dp[i][j] = min;
        return min;
    }
}
