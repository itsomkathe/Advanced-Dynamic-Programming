import java.io.*;
public class Q6MinSquares {
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
                int n = Integer.parseInt(br.readLine());
                System.out.println(solution(n));
            }
        
            public static int solution(int n){
                int[] dp = new int[n+1];
                dp[0] = 0;
                dp[1] = 1;
        
                for(int i = 2;i<=n; i++){
                    int min = Integer.MAX_VALUE;
                    for(int j = 1;j*j<=i; j++){
                        int rem = i - (j*j);
                        if(dp[rem]<min){
                            min = dp[rem];
                        }
                    }
                    dp[i] = min+1;
                }
        
                return dp[n];
        }

        public static int minSquareMemo(int n, Integer[] dp){
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
                    int steps = minSquareMemo((n-square), dp);
                    if(MinSteps>steps){
                        MinSteps = steps;
                    }
                }
                dp[n] = MinSteps+1;
                return MinSteps +1;
        }

        public static int minSquareRecursive(int n){
                if(n == 0){
                    return 0;
                }
        
                int MinSteps = Integer.MAX_VALUE;
                for(int i = 1;i*i<=n; i++){
                    int square = i*i;
                    int steps = minSquareRecursive((n-square));
                    if(MinSteps>steps){
                        MinSteps = steps;
                    }
                }
        
                return MinSteps +1;
        }

}
