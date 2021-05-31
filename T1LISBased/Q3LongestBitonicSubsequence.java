import java.io.*;
public class Q3LongestBitonicSubsequence {
        public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new FileReader("input.txt"));
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                File file = new File("output.txt");
                PrintStream stream = new PrintStream(file);
                System.setOut(stream);
        
                int n = Integer.parseInt(br.readLine());
                int[] arr = new int[n];
                for(int i = 0;i<n; i++){
                    arr[i] = Integer.parseInt(br.readLine());
                }
                
                int[] dp1 = new int[n];
                int[] dp2 = new int[n];
        
                for(int i = 0;i<n; i++){
                    int lmax = 0;
                    for(int j = 0;j<i; j++){
                        if(arr[j]<arr[i]){
                            if(lmax<dp1[j]){
                                lmax = dp1[j];
                            }
                        }
                    }
                    dp1[i] = lmax +1;   
                }
        
                for(int i = n-1;i>=0; i--){
                    int lmax = 0;
                    for(int j = n-1;j>i; j--){
                        if(arr[j]<arr[i]){
                            if(lmax<dp2[j]){
                                lmax = dp2[j];
                            }
                        }
                    }
                    dp2[i] = lmax +1;
                }
                int max = 0;
                for(int i = 0;i<n; i++){
                    int sum = dp1[i] + dp2[i];
                    if(sum>max){
                        max = sum;
                    }
                }
        
                System.out.println(max-1);
                
        }
        
}
