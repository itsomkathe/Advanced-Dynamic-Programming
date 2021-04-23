import java.util.*;
import java.io.*;

public class BooleanParenthesizationRecursive {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        String op = br.readLine();
        System.out.println(BPS(str, op, 0, str.length()-1,true));
    }

    public static int BPS(String str, String op, int i, int j, boolean isTrue){
        if(i == j){
            if(op.charAt(i) == 'T' && isTrue){
                return 1;
            }else if(op.charAt(i) == 'F' && !isTrue){
                return 1;
            }else{
                return 0;
            }
        }
        if(i>j){
            return 0;
        }
        int count = 0;
        for(int k = i;k<=j-1; k++){
            if(isTrue){
                char operator = op.charAt(k);
                if(operator == '&'){
                    int leftTrue = BPS(str, op, i, k, true);
                    int rightTrue = BPS(str, op, k+1, j, true);
                    int myCount = leftTrue*rightTrue;
                    count+=myCount;
                }else if(operator == '|'){
                    int leftTrue = BPS(str, op, i, k, true);
                    int rightTrue = BPS(str, op, k+1, j, true);
                    int leftFalse = BPS(str, op, i, k, false);
                    int rightFalse = BPS(str, op, k+1, j, false);
                    int myCount = (leftTrue*rightTrue)+(leftFalse*rightTrue)+(leftTrue*rightFalse);
                    count+=myCount;
                }else if(operator == '^'){
                    int leftTrue = BPS(str, op, i, k, true);
                    int rightTrue = BPS(str, op, k+1, j, true);
                    int leftFalse = BPS(str, op, i, k, false);
                    int rightFalse = BPS(str, op, k+1, j, false);
                    int myCount = (leftTrue*rightFalse)+(leftFalse*rightTrue);
                    count+=myCount;
                }
            }else{
                char operator = op.charAt(k);
                if(operator == '&'){
                    int leftTrue = BPS(str, op, i, k, true);
                    int rightTrue = BPS(str, op, k+1, j, true);
                    int leftFalse = BPS(str, op, i, k, false);
                    int rightFalse = BPS(str, op, k+1, j, false);
                    int myCount = (leftFalse*rightFalse)+(leftTrue*rightFalse)+(leftFalse*rightTrue);
                    count+=myCount;
                }else if(operator == '|'){
                    int leftFalse = BPS(str, op, i, k, false);
                    int rightFalse = BPS(str, op, k+1, j, false);
                    int myCount = leftFalse*rightFalse;
                    count+=myCount;
                }else if(operator == '^'){
                    int leftTrue = BPS(str, op, i, k, true);
                    int rightTrue = BPS(str, op, k+1, j, true);
                    int leftFalse = BPS(str, op, i, k, false);
                    int rightFalse = BPS(str, op, k+1, j, false);
                    int myCount = (leftTrue*rightTrue)+(leftFalse*rightFalse);
                    count+=myCount;
                }
            }
        }
        return count;
    }
}
