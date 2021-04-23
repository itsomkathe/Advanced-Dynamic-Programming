import java.util.*;
import java.io.*;

public class RodCuttingRecursive {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        String[] sarr = br.readLine().split(" ");
        int[] arr = new int[n+1];
        for(int i = 0;i<n; i++){
            arr[i+1] = Integer.parseInt(sarr[i]);
        }
        System.out.println(rodCutting1(n, arr));
        System.out.println(rodCutting2(n, arr));
        br.close();
    }

    public static int rodCutting1(int n, int[] arr){
        if(n == 0 || n == 1){
            return arr[n];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n; i++){
            int prevOpt = rodCutting1(n-i, arr);
            int myMax = prevOpt + arr[i];
            if(myMax>max){
                max = myMax;
            }
        }
        return max;
    }

    public static int rodCutting2(int n, int[] arr){
        if(n == 0 || n == 1){
            return arr[n];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n; i++){
            int prevOpt = rodCutting2(n-i, arr);
            int myMax = rodCutting2(i, arr) + prevOpt;
            if(myMax>max){
                max = myMax;
            }
        }
        return max;
    } 
}
