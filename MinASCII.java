import java.io.*;
public class MinASCII {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(solution(s1, s2));
        br.close();
    }

    public static int solution(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = dp.length-1;i>=0; i--){
            for(int j = dp[0].length-1;j>=0; j--){
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = 0;
                }else if(i == dp.length-1){
                    dp[i][j] = dp[i][j+1] + (int)s2.charAt(j);
                }else if(j == dp[0].length-1){
                    dp[i][j] = dp[i+1][j] + (int)s1.charAt(i); 
                }else{
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                    }else{
                        int s1Cost = (int)s1.charAt(i) + dp[i+1][j];
                        int s2Cost = (int)s2.charAt(j) + dp[i][j+1];
                        dp[i][j] = Math.min(s1Cost, s2Cost);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
