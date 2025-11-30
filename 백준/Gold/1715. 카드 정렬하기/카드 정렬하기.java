import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;

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
    // Collections를 사용하여 합계와 최대값 계산
    // int sum = s.stream().mapToInt(Integer::intValue).sum();
    // int max = Collections.max(s);
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(Long.parseLong(br.readLine()));
        }

        Long sum = 0L;
        while(pq.size()>1){
            Long a = pq.poll();
            Long b = pq.poll();
            sum+=a+b;
            pq.add(a+b);
        }
        
        System.out.println(sum);
    
    }
}
