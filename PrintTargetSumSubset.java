import java.util.*;
import java.io.*;

public class PrintTargetSumSubset {
    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tar = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[n+1][tar+1];

        for(int i = 0;i<dp.length; i++){
            for(int j = 0;j<dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                }else{
                    if(arr[i-1]<=j){
                        if(dp[i-1][j-arr[i-1]]){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = false;
                        }
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
        BFS(dp, arr);

    }

    public static void BFS(boolean[][] dp, int[] arr){
        Queue<Pair> qu = new ArrayDeque<>();
        qu.add(new Pair(dp.length-1, dp[0].length-1, ""));


        while(qu.size()>0){
            Pair rem = qu.remove();
            
            int x = rem.i;
            int y = rem.j;

            if(x == 0 || y == 0){
                System.out.println(rem.psf);
            }else{
                int val = arr[x-1];
                if(y>=val){
                    boolean inc = dp[x-1][y-val];
                    if(inc){
                        qu.add(new Pair(x-1, y-val, x-1+" "+rem.psf));
                    }
                }
                boolean exc = dp[x-1][y];
                if(exc){
                    qu.add(new Pair(x-1, y, rem.psf));
                }
            
            }
            
        }
    }
}
