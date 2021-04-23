import java.io.*;
public class MinimumASCIIRecursive {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(minASCIIRecursive(s1, s2, 0,0));
        System.out.println(minASCIIMemo(s1, s2, 0, 0, new Integer[s1.length()+1][s2.length()+1]));
    }

    public static int minASCIIRecursive(String s1, String s2, int i, int j){
        if(i == s1.length() && j == s2.length()){
            return 0;
        }else if(i == s1.length()){
            int c = 0;
            for(int k = j;k<s2.length(); k++){
                c+=(int)s2.charAt(k);
            }
            return c;
        }else if(j == s2.length()){
            int c = 0;
            for(int k = i;k<s1.length(); k++){
                c+=(int)s1.charAt(k);
            }
            return c;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return minASCIIRecursive(s1, s2, i+1,j+1);
        }else{
            int s1Cost = (int)s1.charAt(i) + minASCIIRecursive(s1, s2, i+1,j);
            int s2Cost = (int)s2.charAt(j) + minASCIIRecursive(s1, s2, i,j+1);
            return Math.min(s1Cost, s2Cost);
        }
    }

    public static int minASCIIMemo(String s1, String s2, int i, int j, Integer[][] dp){
        if(i == s1.length() && j == s2.length()){
            return 0;
        }else if(i == s1.length()){
            int c = 0;
            for(int k = j;k<s2.length(); k++){
                c+=(int)s2.charAt(k);
            }
            return c;
        }else if(j == s2.length()){
            int c = 0;
            for(int k = i;k<s1.length(); k++){
                c+=(int)s1.charAt(k);
            }
            return c;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = minASCIIMemo(s1, s2, i+1, j+1, dp);
            return dp[i][j];
        }else{
            int s1Cost = (int)s1.charAt(i) + minASCIIMemo(s1, s2, i+1,j,dp);
            int s2Cost = (int)s2.charAt(j) + minASCIIMemo(s1, s2, i,j+1,dp);
            dp[i][j] = Math.min(s1Cost, s2Cost);
            return dp[i][j];
        }
    }
}
