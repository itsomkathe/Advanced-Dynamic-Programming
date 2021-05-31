import java.io.*;
public class Q2MaxSumIncSubsequence {
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
        
                Integer max = Integer.MIN_VALUE;
                Integer[] dp = new Integer[n];
        
                for(int i = 0;i<n; i++){
                    Integer lmax = null;
                    for(int j = 0;j<i; j++){
                        if(arr[j]<=arr[i]){
                            if(lmax == null){
                                lmax = dp[j];
                            }else if(lmax<dp[j]){
                                lmax = dp[j];
                            }
                        }
                    }
                    if(lmax == null){
                        dp[i] = arr[i];
                    }else{
                        dp[i] = arr[i] + lmax;
                    }
        
                    if(dp[i]>max){
                        max = dp[i];
                    }
                }
                System.out.println(max);
        }

        //MEMOIZED CODE
        static int max;
        public static int LISS(int[] arr, int idx){
            max = Integer.MIN_VALUE;
            helper(arr, arr.length-1, new Integer[arr.length]);
            return max;
        }
    
        public static int helper(int[] arr, int idx, Integer[] dp){
            if(idx == 0){
                return arr[idx];
            }
            if(dp[idx] != null){
                return dp[idx];
            }
            int myMax = Integer.MIN_VALUE;
            for(int i = 1;i<=idx; i++){
                int localMax = helper(arr, idx-i, dp);
                if(arr[idx]>arr[idx-i] && localMax+arr[idx]>myMax){
                    myMax = localMax + arr[idx];
                }
            }
            if(myMax>max){
                max = myMax;
            }
            dp[idx] = myMax;
            return myMax;
        }

        //RECURSIVE CODE
        /*static int max;
        public static int LISS(int[] arr, int idx){
            max = Integer.MIN_VALUE;
            helper(arr, arr.length-1);
            return max;
        }
    
        public static int helper(int[] arr, int idx){
            if(idx == 0){
                return arr[idx];
            }
            int myMax = Integer.MIN_VALUE;
            for(int i = 1;i<=idx; i++){
                int localMax = helper(arr, idx-i);
                if(arr[idx]>arr[idx-i] && localMax+arr[idx]>myMax){
                    myMax = localMax + arr[idx];
                }
            }
            if(myMax>max){
                max = myMax;
            }
            return myMax;
        }*/
}
