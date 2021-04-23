import java.io.*;
public class KnightsProbability {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        solution(r, c, n, k);
    }
    private static boolean isValid(int i, int j,int n){
        if(i>=0 && j>=0 && i<n && j<n ){
            return true;
        }else{
            return false;
        }
    }
    public static void solution(int r, int c, int n, int k) {
        double[][] next = new double[n][n];
        double[][] curr = new double[n][n];
		
        curr[r][c] = 1;
        for(int m = 1;m<=k; m++){
            for(int i = 0;i<n; i++){
                for(int j = 0;j<n; j++){
                    if(curr[i][j] != 0){
                        int x = 0;
                        int y = 0;

                        x = i-2;
                        y = j+1;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }

                        x = i-1;
                        y = j+2;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }

                        x = i+1;
                        y = j+2;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }

                        x = i+2;
                        y = j+1;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }

                        x = i+2;
                        y = j-1;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }

                        x = i+1;
                        y = j-2;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }

                        x = i-1;
                        y = j-2;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }

                        x = i-2;
                        y = j-1;
                        if(isValid(x, y, n)){
                            next[x][y] += curr[i][j]/8.0;
                        }
                    }
                }
            }
            curr = next;
            next = new double[n][n];
        }
        double prob = 0;
        for(int i = 0;i<n; i++){
            for(int j = 0;j<n; j++){
                prob += curr[i][j];
            }
        }
        System.out.println(prob);
	}
}
