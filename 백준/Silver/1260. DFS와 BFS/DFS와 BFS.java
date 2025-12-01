import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static  int[] stick;

    public static int node, edge, start;

    public static boolean[] isvisit;
    public static List<Integer>[] S;
    public static StringBuilder sb;

    public static void DFS(int i){
        if(isvisit[i]){
            return ;
        }
        isvisit[i]= true;
        sb.append(i+" ");

        for (int next : S[i]) { 
            if (!isvisit[next]) {
                DFS(next);
            }
        }
    }
    public static void BFS(int i){
        Queue<Integer> queue = new LinkedList<Integer>();

        if(!isvisit[i]){
            isvisit[i]=true;
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int now =queue.poll();
            sb.append(now+" ");
            for(int next : S[now]){
                if(!isvisit[next]){
                    isvisit[next]=true;
                    queue.add(next);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        S = new ArrayList[node+1];
        isvisit = new boolean[node+1];

        for(int i=0;i<node+1;i++){
            S[i]= new ArrayList<>();
        }

        for(int i=0;i<edge;i++){
            int a,b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            S[a].add(b);
            S[b].add(a);
        }
        for(int i=0;i<node+1;i++){
            S[i].sort(null);
        }

        sb = new StringBuilder();
        DFS(start);
        // System.out.println(sb);
        sb.append("\n");
        isvisit = new boolean[node+1];
        BFS(start);
        System.out.println(sb);        
    }
}
