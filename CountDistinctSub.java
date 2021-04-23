import java.util.*;
import java.io.*;

public class CountDistinctSub {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        HashMap<Character, Integer> indices = new HashMap<>();
        long[] dp = new long[str.length()+1];
        dp[0] = 1;
        for(int i = 1;i<=str.length();i++){
            dp[i] = dp[i-1]*2;
            char ch = str.charAt(i-1);
            if(indices.containsKey(ch)){
                dp[i] -= dp[indices.get(ch)-1];
            }
            indices.put(ch, i);
        }
        System.out.println(dp[str.length()] - 1);
    }
}
