import java.util.*;
import java.io.*;

public class DistinctTransformations {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String s1 = br.readLine();//Source
        String s2 = br.readLine();//Target
        System.out.println(distinctTransRecursive(s1, s2, 0, 0));
        System.out.println(distinctTransMemo(s1, s2, 0, 0,new Integer[s1.length()+1][s2.length()+1]));
        System.out.println(solution(s1, s2));
    }
    public static int solution(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = s.length();i>=0; i--){
            for(int j = t.length();j>=0; j--){
                if(i == s.length() && j == t.length()){
                    dp[i][j] = 1;
                }else if(i == s.length()){
                    dp[i][j] = 0;
                }else if(j == t.length()){
                    dp[i][j] = 1;
                }else{
                    if(s.charAt(i) == t.charAt(j)){
                        dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                    }else{
                        dp[i][j] = dp[i+1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static int distinctTransRecursive(String s1, String s2, int i, int j){
        if(i == s1.length() && j == s2.length()){
            return 1;
        }else if(i == s1.length()){
            return 0;
        }else if(j == s2.length()){
            return 1;
        }
        if(s1.charAt(i) == s2.charAt(j)){
            int del = distinctTransRecursive(s1, s2, i+1, j);
            int ndel = distinctTransRecursive(s1, s2, i+1, j+1);
            return del + ndel;
        }else{
            int del = distinctTransRecursive(s1, s2, i+1, j);
            return del;
        }
    }

    public static int distinctTransMemo(String s1, String s2, int i, int j, Integer[][] dp){
        if(i == s1.length() && j == s2.length()){
            return 1;
        }else if(i == s1.length()){
            return 0;
        }else if(j == s2.length()){
            return 1;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            int del = distinctTransMemo(s1, s2, i+1, j,dp);
            int ndel = distinctTransMemo(s1, s2, i+1, j+1,dp);
            dp[i][j] = del + ndel;
            return del + ndel;
        }else{
            int del = distinctTransMemo(s1, s2, i+1, j,dp);
            dp[i][j] = del;
            return del;
        }
    }

}
