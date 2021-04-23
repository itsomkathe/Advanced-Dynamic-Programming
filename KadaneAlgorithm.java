import java.util.*;
import java.io.*;
public class KadaneAlgorithm {
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
        System.out.println(solution(arr));
        br.close();
    }
    public static int solution(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        for(int i = 1;i<arr.length; i++){
            if(currentSum>=0){
                currentSum+=arr[i];
            }else{
                currentSum = arr[i];
            }

            if(currentSum>maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
