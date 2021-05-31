import java.io.*;
public class Q22CatalanNumber {
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
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

        public static int catalanRecursive(int n){
                if(n == 0 || n == 1){
                    return 1;
                }
                int cat = 0;
                for(int i = 0;i<n; i++){
                    cat+=catalanRecursive(i)*catalanRecursive(n-i-1);
                }
                return cat;
        }
        
        public static int catalanMemo(int n, int[] dp){
                if(dp[n] != 0){
                    return dp[n];
                }
                if(n == 0 || n == 1){
                    dp[n] = 1;
                    return 1;
                }
                int cat = 0;
                for(int i = 0;i<n; i++){
                    cat+=catalanMemo(i, dp)*catalanMemo(n-i-1, dp);
                }
                dp[n] = cat;
                return cat;
        }
        
}