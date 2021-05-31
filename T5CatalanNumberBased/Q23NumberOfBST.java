import java.io.*;
public class Q23NumberOfBST {
        public static void main(String[] args) throws Exception {
                // write your code here
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
