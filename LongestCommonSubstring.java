
import java.io.*;
public class LongestCommonSubstring {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(solution(str1, str2));
    }

    public static int solution(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int max = 0;
        for(int i = 0;i<s1.length();i++){
            for(int j = 0;j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
