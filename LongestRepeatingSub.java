import java.io.*;

public class LongestRepeatingSub {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        System.out.println(solution(str));
        br.close();
    }

    public static int solution(String str) {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = n;i>=0; i--){
            for(int j = n;j>=0; j--){
                if(i == n || j == n){
                    dp[i][j] = 0;
                }else{
                    if(str.charAt(i) == str.charAt(j) && i!=j){
                        dp[i][j] = dp[i+1][j+1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
