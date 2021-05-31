import java.util.*;
import java.io.*;
public class Q5RussianDollEnvelopes {
        static class Envelope implements Comparable<Envelope>{
                int width;
                int height;
        
                Envelope(int width, int height){
                    this.width = width;
                    this.height = height;
                }
        
                @Override
                public int compareTo(Envelope o) {
                    return this.width - o.width;
                }
        }
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
                int n = Integer.parseInt(br.readLine());
                Envelope[] env = new Envelope[n];
                for(int i = 0;i<n; i++){
                    String[] sarr = br.readLine().split(" ");
                    env[i] = new Envelope(Integer.parseInt(sarr[0]), Integer.parseInt(sarr[1]));
                }
                Arrays.sort(env);
                
                int omax = 0;
                int[] dp = new int[n];
        
                for(int i = 0;i<n; i++){
                    int max = 0;
                    for(int j = 0;j<i; j++){
                        if(env[i].height>env[j].height && env[i].width>env[j].width){
                            if(max<dp[j]){
                                max = dp[j];
                            }
                        }
                    }
                    dp[i] = max+1;
                    if(omax<dp[i]){
                        omax = dp[i];
                    }
                }
                System.out.println(omax);
        }
}
