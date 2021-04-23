import java.util.*;
import java.io.*;

public class MaxDifferenceZeroesAndOnes {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        System.out.println(solution(str));
        br.close();

        
    }

    public static int solution(String str) {
        int max = 0;
        int currentMax = 0;

        for(int i = 0;i<str.length();i++){
            int val = 0;
            if(str.charAt(i) == '0'){
                val = 1;
            }else if(str.charAt(i) == '1'){
                val = -1;
            }

            if(currentMax>0){
                currentMax+=val;
            }else{
                currentMax = val;
            }

            if(currentMax>max){
                max = currentMax;
            }
        }
        if(max == 0){
            max = -1;
        }
        return max;
    }
}
