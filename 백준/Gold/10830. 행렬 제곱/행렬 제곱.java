import java.io.*;
import java.util.*;


public class Main{

    static int [][] list;
    static int [][] src;
    static int n;


    public static void caculate(int[][] left,int[][] right){


        int [][] sum= new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp=0;
                for(int k=0;k<n;k++){
                    temp += left[i][k]*right[k][j];
                }

                sum[i][j] = temp%1000;
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(sum[i], 0, list[i], 0, n);
        }
    }

    public static void run(long b){

        // 현재 숫자가 1이야?
        if(b==1){
            return ;
        }
        run(b/2);
        caculate(list,list);
    
        if(b%2==1){
            caculate(list,src);
        }
    
    }
    public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        long B = Long.parseLong(st.nextToken());

        list = new int[n][n];     
        src = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                list[i][j] = Integer.parseInt(st.nextToken());
                src[i][j]= list[i][j];        
                if(B==1){
                    list[i][j]= list[i][j]%1000;
                } 
            }
        }
         
        if(B!=1){
            run(B);
        }

        // sum 보여주기
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(list[i][j]+" ");
            }
            System.out.println();
        }


    }
}
