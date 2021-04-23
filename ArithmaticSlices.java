import java.io.*;
public class ArithmaticSlices {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        int count = 0;
        for(int i = 2;i<n; i++){
            if(arr[i]-arr[i-1] == arr[i-1]-arr[i-2]){
                dp[i] += dp[i-1]+1;
                count += dp[i];
            }
        }
        System.out.println(count);
    }
}
