import java.util.*;
import java.io.*;

public class LongestCommonSubRecursive {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(LCS(str1, str2));
    }

    public static int LCS(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0){
            return 0;
        }

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        String r1 = s1.substring(1);
        String r2 = s2.substring(1);

        int myLCS = 0;
        if(c1 == c2){
            int prevLCS = LCS(r1, r2);
            myLCS = prevLCS +1;
        }else{
            int prevLCS = Math.max(LCS(r1, s2), LCS(r2, s1));
            myLCS = prevLCS;
        }
        return myLCS;
    }
}
