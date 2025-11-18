import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static int N,M, result;
    public static List<Node>[] graph;
    public static long[] foxDist; 
    public static long[][] wolfDist;
    
    public static class Node implements Comparable<Node>{
        int idx;
        long distance;
        boolean flag;

        Node(int idx, long distance){
            this.idx = idx;
            this.distance= distance;
        }

        Node(int idx, long distance, boolean flag){
            this.idx = idx;
            this.distance= distance;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node n){
            return Long.compare(this.distance, n.distance);
        }
    }

    public static void foxSolve(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));

        foxDist[1] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(foxDist[curr.idx] < curr.distance){
                continue;
            }

            for(Node node : graph[curr.idx]){
                int idx = node.idx;
                long dist = curr.distance + node.distance;

                if(foxDist[idx] > dist){
                    foxDist[idx] = dist;
                    pq.add(new Node(idx, dist));
                }


            }
        }

    }

    public static void wolfSolve(){

        PriorityQueue<Node> pq = new PriorityQueue();

        pq.add(new Node(1,0,true));

        wolfDist[0][1] = 0;

        while(!pq.isEmpty()){

            Node curr = pq.poll();

            if(wolfDist[curr.flag ? 0 : 1][curr.idx] < curr.distance){
                continue;
            }

            for(Node node: graph[curr.idx]){
                int idx = node.idx;
                long dist = curr.distance;

                if(curr.flag){
                    // 2배
                    dist = dist+ node.distance/2;
                }
                else{
                    // 절반
                    dist = dist + node.distance*2;
                }

                if(wolfDist[curr.flag ? 1:0][idx] > dist){
                    wolfDist[curr.flag ? 1:0][idx] = dist;
                    pq.add(new Node(idx, dist, !curr.flag));
                }
                

            }
        }

    }
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        result = 0;

        for(int i=0;i<M;i++){
            int a,b;
            long c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());

            graph[a].add(new Node(b,c*2));
            graph[b].add(new Node(a,c*2));

        }

        foxDist = new long[N+1];
        wolfDist = new long[2][N+1];

        Arrays.fill(foxDist, Integer.MAX_VALUE);
        Arrays.fill(wolfDist[0], Integer.MAX_VALUE);
        Arrays.fill(wolfDist[1], Integer.MAX_VALUE);

        // 여우 다익스트라 최단 거리 찾기
        foxSolve();
        wolfSolve();

        for(int i=1;i<=N;i++){
            // System.out.println(foxDist[i]+" "+Math.min(wolfDist[0][i], wolfDist[1][i]));
            if(foxDist[i] < Math.min(wolfDist[0][i], wolfDist[1][i])){
                result++;
            }
        }

        

        System.out.println(result);

    
    }




}
