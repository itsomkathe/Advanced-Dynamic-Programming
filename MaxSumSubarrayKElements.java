import java.util.*;
import java.io.*;
public class MaxSumSubarrayKElements {
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
        int k = Integer.parseInt(br.readLine());
        System.out.println(solution(arr, k));
    }

    public static int solution(int[] arr, int k) {
        int[] MSS = new int[arr.length];
        MSS[0] = arr[0];
        int cmax = MSS[0];
        for(int i = 1;i<arr.length; i++){
            if(cmax>0){
                MSS[i] = cmax + arr[i];
                cmax = MSS[i];
            }else{
                MSS[i] = arr[i];
                cmax = MSS[i];
            }
        }
        int currentWindow = 0;
        for(int i = 0;i<k; i++){
            currentWindow+=arr[i];
        }
        int max = Integer.MIN_VALUE;
        if(currentWindow>max){
            max = currentWindow;
        }
        for(int i = 1,j=k;j<arr.length; i++,j++){
            currentWindow-=arr[i-1];
            currentWindow+=arr[j];
            if(currentWindow>max){
                max = currentWindow;
            }
            if(currentWindow+MSS[i-1]>max){
                max = currentWindow + MSS[i-1];
            }
        }
        return max;
    }
}
