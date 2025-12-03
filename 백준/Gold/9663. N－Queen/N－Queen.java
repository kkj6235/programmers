import java.io.*;
import java.util.*;



public class Main{

    // public static int [] list;
    public static int n;
    public static int answer;
    public static int [] col;

    public static boolean promising(int row, int column){

        for(int i=0;i<row;i++){
            if(col[i]==column){
                return false;
            }
            if(Math.abs(i-row)==Math.abs(col[i]-column)){
                return false;
            }
        }
        
        return true;
    }
    public static void dfs(int row, int column){
    
        col[row]=column;


        if(row==n-1){
            answer++;
            return ;
        }
    
        for(int i=0;i<n;i++){

            if(promising(row+1, i)){
                dfs(row+1, i);
            }
        }
    }

    public static void main(String args[]) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        n = Integer.parseInt(br.readLine());
        
        col = new int[n];
        answer = 0;

        for(int i=0;i<n;i++){
            col[i]=-1;
        }

        for(int i=0;i<n;i++){
            dfs(0,i);
        }
        System.out.println(answer);
        
        
    }
}

