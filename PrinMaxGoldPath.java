import java.util.*;
import java.io.*;

public class PrinMaxGoldPath {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int[][] dp = new int[n][m];
        for(int j = dp[0].length-1;j>=0; j--){
            for(int i = 0;i<dp.length; i++){
                if(j == dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i == 0){
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1])+arr[i][j];
                }else if(i == dp.length-1){
                    dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j+1])+arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]))+arr[i][j];
                }
            }
        }
        int max = 0;
        for(int i = 0;i<dp.length;i++){
            if(dp[i][0]>max){
                max = dp[i][0];
            }
        }
        System.out.println(max);
        for(int i = 0;i<dp.length; i++){
            if(dp[i][0] == max){
                DFS(dp, i, 0, i+"");
            }
        }
        /**for(int i = 0;i<n; i++){
            for(int j = 0;j<m; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }**/
    }

    public static void DFS(int[][] dp, int i,int j, String psf){
        if(j == dp[0].length-1){
            System.out.println(psf);
            return;
        }
        if(i == 0){
            if(dp[i][j+1]>dp[i+1][j+1]){
                DFS(dp, i, j+1, psf+" d2");
            }else if(dp[i][j+1]<dp[i+1][j+1]){
                DFS(dp, i+1, j+1, psf+" d3");
            }else{
                DFS(dp, i, j+1, psf+" d2");
                DFS(dp, i+1, j+1, psf+" d3");
            }
        }else if(i == dp[0].length-1){
            if(dp[i][j+1]>dp[i-1][j+1]){
                DFS(dp, i, j+1, psf+" d2");
            }else if(dp[i][j+1]<dp[i-1][j+1]){
                DFS(dp, i-1, j+1, psf+" d1");
            }else{
                DFS(dp, i-1, j+1, psf+" d1");
                DFS(dp, i, j+1, psf+" d2");
            }
        }else{
            if(dp[i-1][j+1] == dp[i][j+1] && dp[i][j+1] == dp[i+1][j+1]){
                DFS(dp, i-1, j+1, psf+" d1");
                DFS(dp, i, j+1, psf+" d2");
                DFS(dp, i+1, j+1, psf+" d3");
            }else if(dp[i-1][j+1] == dp[i][j+1]){
                if(dp[i-1][j+1]>dp[i+1][j+1]){
                    DFS(dp, i-1, j+1, psf+" d1");
                    DFS(dp, i, j+1, psf+" d2");
                }else{
                    DFS(dp, i+1, j+1, psf+" d3");
                }
            }else if(dp[i][j+1] == dp[i+1][j+1]){
                if(dp[i][j+1]>dp[i-1][j+1]){
                    DFS(dp, i, j+1, psf+" d2");
                    DFS(dp, i+1, j+1, psf+" d3");
                }else{
                    DFS(dp, i-1, j+1, psf+" d1");
                }
            }else if(dp[i-1][j+1] == dp[i+1][j+1]){
                if(dp[i-1][j+1]>dp[i][j+1]){
                    DFS(dp, i-1, j+1, psf+" d1");
                    DFS(dp, i+1, j+1, psf+" d3");
                }else{
                    DFS(dp, i, j+1, psf+" d2");
                }
            }else{
                int max = Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
                if(dp[i-1][j+1] == max){
                    DFS(dp, i-1, j+1, psf+" d1");
                }else if(dp[i][j+1] == max){
                    DFS(dp, i, j+1, psf+" d2");
                }else if(dp[i+1][j+1] == max){
                    DFS(dp, i+1, j+1, psf+" d3");
                }
            }
        }
    }
}
