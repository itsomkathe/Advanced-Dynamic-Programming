import java.util.*;
import java.io.*;

public class MaximumSumIncrSubRecursive {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = Integer.parseInt(sarr[i]);
        }
        System.out.println(LISS(arr, n-1));

    }

    static int max;
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
    }
}
