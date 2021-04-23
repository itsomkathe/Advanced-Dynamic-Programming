import java.util.*;
import java.io.*;

public class LongestIncreasingSubMemo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = Integer.parseInt(sarr[i]);
        }

        System.out.println(LIS(arr, arr.length-1));
    }

    static int max;
    public static int LIS(int[] arr, int idx){
        max = 1;
        helper(arr, idx, new int[arr.length]);
        return max;
    }

    public static int helper(int[] arr, int idx, int[] dp){
        if(idx == 0){
            return 1;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        int myMax = 1;
        for(int i = 1;i<=idx; i++){
            int localLis = helper(arr, idx-i, dp);
            if(arr[idx]>arr[idx-i] && localLis+1>myMax){
                myMax = localLis+1;
            }
        }
        if(myMax>max){
            max = myMax;
        }
        dp[idx] = myMax;
        return myMax;
    }
        

}
