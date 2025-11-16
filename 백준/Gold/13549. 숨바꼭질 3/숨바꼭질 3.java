import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static int N,K,min;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        
        Queue<Node> queue = new LinkedList();

        queue.add(new Node(N,0));
        // visited[N] = true;

        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp.sum>100000 || tmp.sum<0){
                continue;
            }
            if(visited[tmp.sum]){
                continue;
            }
            visited[tmp.sum] = true;

            if(tmp.sum==K){
                min = tmp.count;
                break;
            }
            queue.add(new Node(tmp.sum*2, tmp.count));
            queue.add(new Node(tmp.sum-1, tmp.count+1));
            queue.add(new Node(tmp.sum+1, tmp.count+1));

        }

        System.out.println(min);
        
    }

    

    public static class Node{
        int sum;
        int count;

        Node(int sum, int count){
            this.sum= sum;
            this.count=count;
        }

        // implements Comparable<Node>

        // @Override
        // public int compareTo(Node n){
        //     return Long.compare(this.distance, n.distance);
        // }
    }


}
