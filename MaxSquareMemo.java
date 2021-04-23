import java.util.*;
import java.io.*;

public class MaxSquareMemo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        System.out.println(maxSquare(n, new Integer[n+1]));
        
    }

    public static int maxSquare(int n, Integer[] dp){
        if(n == 0){
            dp[0] = 0;
            return 0;
        }
        if(dp[n] != null){
            return dp[n];
        }

        int MinSteps = Integer.MAX_VALUE;
        for(int i = 1;i*i<=n; i++){
            int square = i*i;
            int steps = maxSquare((n-square), dp);
            if(MinSteps>steps){
                MinSteps = steps;
            }
        }
        dp[n] = MinSteps+1;
        return MinSteps +1;
    }
}
