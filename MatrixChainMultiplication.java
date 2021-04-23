import java.util.*;
import java.io.*;

public class MatrixChainMultiplication {
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
        System.out.println(mcm(arr));
        br.close();
    }
    public static int mcm(int[] arr){
        int[][] dp = new int[arr.length-1][arr.length-1];
        for(int g = 0;g<dp.length; g++){
            for(int i = 0,j=g;j<dp[0].length; i++,j++){
                if(g == 0){
                    dp[i][j] = 0;
                }else if(g == 1){
                    dp[i][j] = arr[i]*arr[j]*arr[j+1];
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k = i;k<j; k++){
                        int prev1 = dp[i][k];
                        int prev2 = dp[k+1][j];
                        int myCost = (arr[i]*arr[k+1]*arr[j+1])+prev1+prev2;
                        if(myCost<min){
                            min = myCost;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp[0].length-1];
	}
}
