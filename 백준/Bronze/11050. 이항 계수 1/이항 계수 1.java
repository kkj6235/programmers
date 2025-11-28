import java.io.*;
import java.util.*;



public class Main{

    public static int N,K;
    public static BufferedReader br;
    public static StringTokenizer st;


    public static int dp(int i,int j){

        if(j>i){
            return 0;
        }

        if(i==0 || j==0){
            return 1;
        }
        
        return dp(i-1,j) + dp(i-1,j-1);
    }

    public static void main(String args[])throws Exception{
        
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        

        System.out.println(dp(N,K));


    }

}