import java.util.*;
import java.io.*;

public class OptimalBST {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        String[] farr = br.readLine().split(" ");

        int[] keys = new int[n];
        int[] frequency = new int[n];
        for(int i = 0;i<n; i++){
            keys[i] = Integer.parseInt(arr[i]);
            frequency[i] = Integer.parseInt(farr[i]);
        }
        System.out.println(optimalBSTRecursive(keys, frequency, n, 0, n-1));
        System.out.println(optimalBSTMemo(keys, frequency, n, 0, n-1, new Integer[n][n]));
        optimalBST(keys, frequency, n);
    }

    public static int optimalBSTRecursive(int[] keys, int[] frequency, int n, int i, int j) {
        if(i == j){
            return frequency[i];
        }
        if(i>j){
            return 0;
        }
        int extra = sum(frequency, i, j);
        int min = Integer.MAX_VALUE;
        for(int k = i;k<=j; k++){
            int leftCost = optimalBSTRecursive(keys, frequency, n, 0, k-1);
            int rightCost = optimalBSTRecursive(keys, frequency, n, k+1, j);
            int myCost = leftCost + rightCost;
            if(myCost<min){
                min = myCost;
            }
        }
        return extra + min;
    }

    public static int sum(int[] freq, int i, int j){
        int s = 0;
        for(int k = i;k<=j; k++){
            s+=freq[k];
        }
        return s;
    }

    public static int optimalBSTMemo(int[] keys, int[] frequency, int n, int i, int j, Integer[][] dp) {
        if(i == j){
            return frequency[i];
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int extra = sum(frequency, i, j);
        int min = Integer.MAX_VALUE;
        for(int k = i;k<=j; k++){
            int leftCost = optimalBSTMemo(keys, frequency, n, 0, k-1, dp);
            int rightCost = optimalBSTMemo(keys, frequency, n, k+1, j, dp);
            int myCost = leftCost + rightCost;
            if(myCost<min){
                min = myCost;
            }
        }
        dp[i][j] = extra+min;
        return extra + min;
    }

    private static void optimalBST(int[] keys, int[] frequency, int n) {
        int[][] dp = new int[n][n];

        for(int g = 0;g<n; g++){
            for(int i = 0,j = g;j<n; i++,j++){
                if(g == 0){
                    dp[i][j] = frequency[i];
                }else if(g == 1){
                    int f1 = frequency[i];
                    int f2 = frequency[j];
                    dp[i][j] = Math.min(f1 + 2*f2, f2 + 2*f1);
                }else{
                    int s = sum(frequency, i, j);
                    int min = Integer.MAX_VALUE;
                    for(int k = i;k<=j; k++){
                        int left = k == 0?0:dp[i][k-1];
                        int right = k == j?0:dp[k+1][j];
                        if(left + right + s < min){
                            min = left + right + s;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }

        System.out.println(dp[0][n-1]);

    }
}
