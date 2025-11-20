import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;

    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        for(long i=N;i<=M;i++){

            if(i==1){
                continue;
            }
            else if(i==2){
                System.out.println(i);
                continue;
            }
            int j=2; 
            boolean flag = false;
            
            for(j=2;j<Math.sqrt(i)+1;j++){
                if(i%j==0){
                    flag =true;
                    break;
                }
            }
            if(!flag){
                System.out.println(i);
            }
        }
 
    
    }




}
