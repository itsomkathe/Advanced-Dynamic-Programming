import java.util.*;
import java.io.*;
public class EditDistance {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(editDistanceRecursive(str1, str2, 0, 0));
        System.out.println(editDistanceMemo(str1, str2, 0, 0, new Integer[str1.length()][str2.length()]));
        System.out.println(solution(str1, str2));

    }
    public static int solution(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = str1.length();i>=0; i--){
            for(int j = str2.length();j>=0; j--){
                if(i == str1.length() && j == str2.length()){
                    dp[i][j] = 0;
                }
                else if(i == str1.length()){
                    dp[i][j] = str2.length()-j;
                }else if(j == str2.length()){
                    dp[i][j] = str1.length()-i;
                }
                else{
                    if(str1.charAt(i) == str2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                    }else{
                        dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]))+1;
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static int editDistanceRecursive(String str1, String str2, int i, int j){
        if(i == str1.length()){
            return str2.length()-j;
        }
        if(j == str2.length()){
            return str1.length()-i;
        }
        if(str1.charAt(i) == str2.charAt(j)){
            return editDistanceRecursive(str1, str2, i+1, j+1);
        }else{
            int insert = editDistanceRecursive(str1, str2, i, j+1);
            int remove = editDistanceRecursive(str1, str2, i+1, j);
            int replace = editDistanceRecursive(str1, str2, i+1, j+1);

            return Math.min(insert, Math.min(remove, replace)) + 1;
        }
    }

    public static int editDistanceMemo(String str1, String str2, int i, int j, Integer[][] dp){
        if(i == str1.length()){
            return str2.length()-j;
        }
        if(j == str2.length()){
            return str1.length()-i;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(str1.charAt(i) == str2.charAt(j)){
            dp[i][j] = editDistanceMemo(str1, str2, i+1, j+1, dp);
            return dp[i][j];
        }else{
            int remove = editDistanceMemo(str1, str2, i+1, j, dp);
            int insert = editDistanceMemo(str1, str2, i, j+1, dp);
            int replace = editDistanceMemo(str1, str2, i+1, j+1, dp);
            dp[i][j] = Math.min(insert, Math.min(remove, replace)) + 1;
            return dp[i][j];
        }
    }
}
