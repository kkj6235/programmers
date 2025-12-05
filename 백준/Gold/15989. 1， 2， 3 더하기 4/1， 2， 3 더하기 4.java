import java.io.*;
import java.util.*;


public class Main{

    public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        long [][] dp = new long[10001][4];

        dp[1][1]=1;
        
        dp[2][1]=1;
        dp[2][2]=1;

        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;

        
        for(int i=4;i<10001;i++){
            dp[i][1]=dp[i-1][1];
            dp[i][2] = dp[i-2][1]+dp[i-2][2];
            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        }

        long t = Long.parseLong(br.readLine());


        for(long i=0;i<t;i++){
            
            int temp = Integer.parseInt(br.readLine());
            if(temp==1){
                System.out.println(1);                
            }
            else if(temp==2){
                System.out.println(2);    
            }
            else{
                long sum = dp[temp][1]+dp[temp][2]+dp[temp][3];
                System.out.println(sum);    
            }
            
            
        }

    }
}

