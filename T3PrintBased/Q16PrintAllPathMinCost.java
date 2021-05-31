import java.util.*;
import java.io.*;
public class Q16PrintAllPathMinCost {
        static class Pair{
                int i;
                int j;
                String psf;
        
                Pair(int i, int j, String psf){
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
                int m = Integer.parseInt(br.readLine());
                int[][] arr = new int[n][m];
        
                for (int i = 0; i < n; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = Integer.parseInt(str.split(" ")[j]);
                    }
                }
        
                int[][] dp = new int[n][m];
                for(int i = n-1;i>=0; i--){
                    for(int j = m-1;j>=0; j--){
                        if(i == n-1 && j == m-1){
                            dp[i][j] = arr[i][j];
                        }else if(i == n-1){
                            dp[i][j] = dp[i][j+1]+arr[i][j];
                        }else if(j == m-1){
                            dp[i][j] = dp[i+1][j]+arr[i][j];
                        }else{
                            dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])+arr[i][j];
                        }
                        
                    }
                }
                System.out.println(dp[0][0]);
                /**for(int i = 0;i<n; i++){
                    for(int j = 0;j<m; j++){
                        System.out.print(dp[i][j]+" ");
                    }
                    System.out.println();
                }**/
                DFS(dp, 0, 0, "");
                BFS(dp);
                
            }
        
            public static void DFS(int[][] dp, int i, int j, String psf){
                if(i == dp.length-1 && j == dp[0].length-1){
                    System.out.println(psf);
                    return;
                }
                
                if(i == dp.length -1){
                    DFS(dp, i, j+1, psf+"H");
                }else if(j == dp[0].length-1){
                    DFS(dp, i+1, j, psf+"V");
                }else{
                    if(dp[i+1][j]<dp[i][j+1]){
                        DFS(dp, i+1, j, psf+"V");
                    }else if(dp[i+1][j]>dp[i][j+1]){
                        DFS(dp, i, j+1, psf+"H");
                    }else{
                        DFS(dp, i+1, j, psf+"V");
                        DFS(dp, i, j+1, psf+"H");
                    }    
                }
            }
        
            public static void BFS(int[][] dp){
                Queue<Pair> qu = new ArrayDeque<>();
                qu.add(new Pair(0, 0,""));
        
                while(qu.size()>0){
                    Pair rem = qu.remove();
        
                    int x = rem.i;
                    int y = rem.j;
        
                    if(x == dp.length-1 && y == dp[0].length-1){
                        System.out.println(rem.psf);
                    }else if(x == dp.length -1){
                        qu.add(new Pair(x, y+1, rem.psf+"H"));
                    }else if(y == dp[0].length-1){
                        qu.add(new Pair(x+1, y, rem.psf+"V"));
                    }else{
                        if(dp[x+1][y]<dp[x][y+1]){
                            qu.add(new Pair(x+1, y, rem.psf+"V"));
                        }else if(dp[x+1][y]>dp[x][y+1]){
                            qu.add(new Pair(x, y+1, rem.psf+"H"));
                        }else{
                            qu.add(new Pair(x+1, y, rem.psf+"V"));
                            qu.add(new Pair(x, y+1, rem.psf+"H"));
                        }
                    }
                }
            }
}
