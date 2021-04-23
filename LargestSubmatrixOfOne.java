import java.io.*;
public class LargestSubmatrixOfOne {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);
        String[] in = br.readLine().split(" ");
        int m = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);

        int[][] arr = new int[m][n];

        for(int i = 0;i<m; i++){
            String[] sarr = br.readLine().split(" ");
            for(int j = 0;j<n; j++){
                arr[i][j] = Integer.parseInt(sarr[j]);
            }
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        int max = 0;
        for(int i = arr.length-1;i>=0; i--){
            for(int j = arr[0].length-1;j>=0; j--){
                if(i == arr.length - 1 || j == arr[0].length-1){
                    dp[i][j] = arr[i][j];
                }else{
                    if(arr[i][j] == 0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]))+1;
                    }
                }
                if(dp[i][j]>max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
