import java.io.*;
// import java.util.*;

public class Main{

    public static BufferedReader br;


    public static void main(String args[]) throws IOException{
        

        br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        
        char[] result = br.readLine().toCharArray();
        
        if(n==1){
            System.out.println(new String(result));
            return ;
        }

        for(int i=1;i<n;i++){
            String tmp = br.readLine();
            for(int j=0;j<result.length;j++){

                if(tmp.charAt(j)!=result[j]){
                    result[j]= '?';
                }
            }
        }

        System.out.println(new String(result));


    }
}