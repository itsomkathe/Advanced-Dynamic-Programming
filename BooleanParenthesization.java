import java.util.*;
import java.io.*;
public class BooleanParenthesization {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str = br.readLine();
        String op = br.readLine();
        System.out.println(solution(str, op));
    }

    public static int solution(String str, String op) {
        int n = str.length();
        int[][] dpt = new int[n][n];
        int[][] dpf = new int[n][n];

        for(int g = 0;g<n; g++){
            for(int i = 0,j = g;j<n; i++,j++){
                if(g == 0){
                    char ch = str.charAt(i);
                    if(ch == 'T'){
                        dpt[i][j] = 1;
                        dpf[i][j] = 0;
                    }else if(ch == 'F'){
                        dpt[i][j] = 0;
                        dpf[i][j] = 1;
                    }
                }else{
                    for(int k = i;k<j; k++){
                        char operator = op.charAt(k);
                        int leftTrue = dpt[i][k];
                        int rightTrue = dpt[k+1][j];
                        int leftFalse = dpf[i][k];
                        int rightFalse = dpf[k+1][j];
                        if(operator == '&'){
                            dpt[i][j] += rightTrue*leftTrue;
                            dpf[i][j] += (rightFalse*leftFalse)+(rightTrue*leftFalse)+(rightFalse*leftTrue);
                        }else if(operator == '|'){
                            dpt[i][j] += (rightTrue*leftTrue)+(rightTrue*leftFalse)+(rightFalse*leftTrue);
                            dpf[i][j] += rightFalse*leftFalse;
                        }else if(operator == '^'){
                            dpt[i][j] += (rightTrue*leftFalse) + (rightFalse*leftTrue);
                            dpf[i][j] += (rightTrue*leftTrue) + (rightFalse*leftFalse);
                        }
                    }
                }     
            }
        }
        return dpt[0][n-1];
    }
}
