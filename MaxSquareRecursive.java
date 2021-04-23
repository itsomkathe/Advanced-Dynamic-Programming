import java.util.*;
import java.io.*;

public class MaxSquareRecursive {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        System.out.println(maxSquare(n));

    }

    public static int maxSquare(int n){
        if(n == 0){
            return 0;
        }

        int MinSteps = Integer.MAX_VALUE;
        for(int i = 1;i*i<=n; i++){
            int square = i*i;
            int steps = maxSquare((n-square));
            if(MinSteps>steps){
                MinSteps = steps;
            }
        }

        return MinSteps +1;
    }
}
