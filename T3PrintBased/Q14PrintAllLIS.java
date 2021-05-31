import java.util.*;
import java.io.*;
public class Q14PrintAllLIS {
        static class Pair{
                int val;
                int lis;
                int index;
                String psf;
        
                Pair(int val, int lis, int index, String psf){
                    this.val = val;
                    this.lis = lis;
                    this.index = index;
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
            String[] sarr = br.readLine().split(" ");
            for(int i = 0;i<n; i++){
                arr[i] = Integer.parseInt(sarr[i]);
            }
            int[] dp = new int[n];
            int omax = 0;
            
            for(int i = 0;i<n; i++){
                int max = 0;
                for(int j = 0;j<i; j++){
                    if(arr[j]<=arr[i]){
                        if(dp[j]>max){
                            max = dp[j];
                        }
                    }
                }
                dp[i] = max+1;
                if(omax<max+1){
                    omax = max+1;
                }
            }
            System.out.println(omax);
            Queue<Pair> qu = new ArrayDeque<>();
            //Applying Breadth First Search
            for(int i=0;i<n;i++){
                if(dp[i] == omax){
                    qu.add(new Pair(arr[i], dp[i], i, arr[i]+""));
                    while(qu.size()>0){
                        Pair rem = qu.remove();
                        if(rem.lis == 1){
                            System.out.println(rem.psf);
                        }
                        for(int j = rem.index-1;j>=0; j--){
                            if(dp[j] == rem.lis-1 && arr[j]<=rem.val){
                                qu.add(new Pair(arr[j], dp[j], j, arr[j]+"->"+rem.psf));
                            }
                        }
                    }
                }
            }
        
        
            }
        
}