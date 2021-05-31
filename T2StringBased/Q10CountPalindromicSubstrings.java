import java.io.*;
public class Q10CountPalindromicSubstrings {
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
                String str = br.readLine();
                boolean[][] dp = new boolean[str.length()][str.length()];
        
                int count = 0;
                for(int g = 0;g<str.length(); g++){
                    for(int i = 0,j = g;j<dp.length; i++, j++){
                        if(g == 0){
                            dp[i][j] = true;
                        }else if(g == 1){
                            dp[i][j] = str.charAt(i) == str.charAt(j) ? true:false;
                        }else{
                            if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]){
                                dp[i][j] = true;
                            }
                        }
                        if(dp[i][j]){
                            count++;
                        }
                    }
                }
                System.out.println(count);
        }
}
