import java.util.*;
import java.io.*;

public class NonOverlappingBridges {
    static class Bridge implements Comparable<Bridge>{
        int north;
        int south;

        Bridge(int north, int south){
            this.north = north;
            this.south = south;
        }

        @Override
        public int compareTo(Bridge o) {
            if(this.north != o.north){
                return this.north - o.north;
            }else{
                return this.south - o.south;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        Bridge[] total = new Bridge[n];
        for(int i = 0;i<n; i++){
            String[] sarr = br.readLine().split(" ");
            total[i] = new Bridge(Integer.parseInt(sarr[0]),Integer.parseInt(sarr[1]));
        }
        Arrays.sort(total);

        int omax = 0;
        int[] dp = new int[n];

        for(int i = 0;i<n; i++){
            int max = 0;
            for(int j = 0;j<i; j++){
                if(total[i].south>total[j].south){
                    if(max<dp[j]){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max +1;
            if(omax<dp[i]){
                omax = dp[i];
            }
        }

        System.out.println(omax);
    }
}
