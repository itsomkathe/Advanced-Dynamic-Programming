import java.io.*;
import java.util.*;
public class Q15PrintAllPathMinJumps {
        static class Pair{
                int index;
                int jumps;
                int minJump;
                String psf;
        
                Pair(int index, int jumps, int minJump, String psf){            
                    this.index = index;
                    this.jumps = jumps;
                    this.minJump = minJump;
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
                for(int i = 0;i<n; i++){
                    arr[i] = Integer.parseInt(br.readLine());
                }
        
                solution(arr);
        
            }
        
            public static void solution(int[] arr){
                Integer[] dp = new Integer[arr.length];
                dp[dp.length-1] = 0;
                for(int i = arr.length-2;i>=0; i--){
                    int min = Integer.MAX_VALUE;
                    for(int j = 1;j<=arr[i]; j++){
                        if(i+j<dp.length){
                            if(dp[i+j] != null && dp[i+j]<min){
                                min = dp[i+j];
                            }
                        }
                    }
                    if(arr[i] == 0){
                        dp[i] = null;
                    }else{
                        dp[i] = min+1;
                    }
                }
                for (Integer integer : dp) {
                    System.out.print(integer+" ");
                }
                System.out.println();
                System.out.println(dp[0]);
                Queue<Pair> qu = new ArrayDeque<>();
                qu.add(new Pair(0, arr[0], dp[0], 0+""));
        
                while(qu.size()>0){
                    Pair rem = qu.remove();
                    if(rem.minJump == 0){
                        System.out.println(rem.psf+" .");
                    }
                    for(int i = 1;i<=rem.jumps && rem.index+i<dp.length;i++){
                        int idx = rem.index+i;
                        if(dp[idx] != null && dp[idx] == rem.minJump-1){
                            qu.add(new Pair(idx, arr[idx], dp[idx], rem.psf+" -> "+idx));
                        }
                    }
                }
            }
}
