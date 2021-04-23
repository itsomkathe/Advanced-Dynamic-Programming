import java.util.*;
import java.io.*;

public class NumericKeypad {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
        br.close();
    }

    public static int solution(int n) {
        int[][] dp = new int[n+1][10];
        int[][] graph = {
            {0,8},
            {1,2,4},
            {1,2,3,5},
            {2,3,6},
            {1,4,5,7},
            {2,4,5,6,8},
            {3,6,9,5},
            {4,7,8},
            {0,7,5,8,9},
            {6,9,8}
        };
        for(int i = 1;i<=n; i++){
            for(int j = 0;j<10; j++){
                if(i == 1){
                    dp[i][j] = 1;
                }else{
                    for (int k : graph[j]) {
                        dp[i][j]+=dp[i-1][k];
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0;i<10; i++){
            sum+=dp[n][i];
        }
        return sum;
    }
}
