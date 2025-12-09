import java.io.*;
import java.util.*;


public class Main{

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 
        
       
        ArrayList<Integer>[] list = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            list[i]= new ArrayList<>();
            list[i].add(0);
        }

        for(int i=1;i<=k;i++){
            list[0].add(0);
        }

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken()); 
            int v = Integer.parseInt(st.nextToken()); 

            for(int j=1;j<=k;j++){
                if(j<w){
                    list[i].add(list[i-1].get(j));
                }
                else{                
                    list[i].add(Math.max(list[i-1].get(j), v + list[i-1].get(j-w)));
                }
            }


        } 

        System.out.println(list[n].get(k));

    }
}
