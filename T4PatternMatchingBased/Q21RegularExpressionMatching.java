import java.io.*;
public class Q21RegularExpressionMatching {
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
                String str = br.readLine();
                String pattern = br.readLine();
                System.out.println(solution(str, pattern));
                br.close();
        }
        
            public static boolean solution(String str, String pattern){
                boolean[][] dp = new boolean[pattern.length()+1][str.length()+1];
                for(int i = 0;i<dp.length; i++){
                    for(int j = 0;j<dp[0].length; j++) {
                        if(i==0 && j==0){
                            dp[i][j] = true;
                        }else if(i == 0){
                            dp[i][j] = false;
                        }else if(j == 0){
                            char pc = pattern.charAt(i-1);
                            if(pc == '*'){
                                dp[i][j] = dp[i-2][j];
                            }else{
                                dp[i][j] = false;
                            }
                        }else{
                            char pc = pattern.charAt(i-1);
                            char sc = str.charAt(j-1);
        
                            if(pc == '*'){
                                dp[i][j] = dp[i-2][j];
                                if(sc == pattern.charAt(i-2) || pattern.charAt(i-2) == '.'){
                                    dp[i][j] = dp[i][j] || dp[i][j-1];
                                }
                            }else if(pc == '.'){
                                dp[i][j] = dp[i-1][j-1];
                            }else if(pc == sc){
                                dp[i][j] = dp[i-1][j-1];
                            }else{
                                dp[i][j] = false;
                            }
                        }
                    }
                }
                return dp[pattern.length()][str.length()];
        }
}
