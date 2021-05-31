import java.io.*;
public class Q9CountPalindromicSubsequence {

        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
                String str = br.readLine();
                int n = str.length();
        
                int[][] dp = new int[n][n];
        
                for(int g = 0;g<n; g++){
                    for(int i = 0, j = g;j<n; i++, j++){
                        if(g==0){
                            dp[i][j] = 1;
                        }else if(g==1){
                            dp[i][j] = str.charAt(i) == str.charAt(j)?3:2;
                        }else{
                            if(str.charAt(i) == str.charAt(j)){
                                dp[i][j] = dp[i][j-1] + dp[i+1][j]+ 1;
                            }else{
                                dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                            }
                        }
                    }
                }
                System.out.println(dp[0][n-1]);
        }
        //MEMOIZED CODE
        public static int CPSMemo(String str, int i, int j, int[][] dp){
                if(i>j){
                    return 0;
                }
                if(i == j){
                    return 1;
                }
                if(dp[i][j] != 0){
                    return dp[i][j];
                }
                if(str.charAt(i) == str.charAt(j)){
                    int count = CPSMemo(str, i, j-1, dp) + CPSMemo(str, i+1, j, dp) +1;
                    dp[i][j] = count;
                    return count;
                }else{
                    int count = CPSMemo(str, i, j-1, dp) + CPSMemo(str, i+1, j, dp) - CPSMemo(str, i+1, j-1, dp);
                    dp[i][j] = count;
                    return count;
                }
        }

        //RECURSIVE CODE
        public static int CPS(String str, int i, int j){
                if(i>j){
                    return 0;
                }
                if(i == j){
                    return 1;
                }
                if(str.charAt(i) == str.charAt(j)){
                    int count = CPS(str, i, j-1) + CPS(str, i+1, j) +1;
                    return count;
                }else{
                    int count = CPS(str, i, j-1) + CPS(str, i+1, j) - CPS(str, i+1, j-1);
                    return count;
                }
        }
}
