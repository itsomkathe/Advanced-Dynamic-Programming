import java.io.*;
public class Q7LongestCommonSubsequence {
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
                String str1 = br.readLine();
                String str2 = br.readLine();
        
                int[][] dp = new int[str1.length()+1][str2.length()+1];
        
                for(int i = dp.length-1;i>=0; i--){
                    for(int j = dp[0].length-1;j>=0; j--){
                        if(i == dp.length-1 || j == dp[0].length-1){
                            dp[i][j] = 0;
                        }else{
                            if(str1.charAt(i) == str2.charAt(j)){
                                dp[i][j] = dp[i+1][j+1]+1;
                            }else{
                                dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                            }
                        }
                    }
                }
                System.out.println(dp[0][0]);
        }

        //MEMOIZED CODE
        public static int LCSMemo(String s1, String s2,int i, int j, Integer[][] dp){
                if(i == s1.length() || j == s2.length()){
                    dp[i][j] = 0;
                    return 0;
                }
                if(dp[i][j] != null){
                    return dp[i][j];
                }
                int myLCS = 0;
                if(s1.charAt(i) == s2.charAt(j)){
                    int prevLCS = LCSMemo(s1, s2, i+1, j+1, dp);
                    myLCS = prevLCS + 1;
                }else{
                    int prevLCS = Math.max(LCSMemo(s1, s2, i+1, j, dp), LCSMemo(s1, s2, i, j+1, dp));
                    myLCS = prevLCS;
                }
                dp[i][j] = myLCS;
                return myLCS;
        }

        //RECURSIVE CODE
        public static int LCS(String s1, String s2){
                if(s1.length() == 0 || s2.length() == 0){
                    return 0;
                }
        
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
        
                String r1 = s1.substring(1);
                String r2 = s2.substring(1);
        
                int myLCS = 0;
                if(c1 == c2){
                    int prevLCS = LCS(r1, r2);
                    myLCS = prevLCS +1;
                }else{
                    int prevLCS = Math.max(LCS(r1, s2), LCS(r2, s1));
                    myLCS = prevLCS;
                }
                return myLCS;
        }
        
}