import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;

    static int count=0;

    public static void DFS(int n){
        if(visited[n]){
           return ; 
        }
        visited[n]=true;
        for(int i=0;i<A[n].size();i++){
            DFS(A[n].get(i));
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        A= new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<=n;i++){
            A[i]=new ArrayList<Integer>();
            visited[i]=false;
        }

        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int from= Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            A[from].add(to);
            A[to].add(from);
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                DFS(i);    
                count++;
            }
                
        }


        System.out.println(count);
    }
}