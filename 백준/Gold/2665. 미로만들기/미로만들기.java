import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static int N,answer;
    public static boolean[][] visited, open;
    public static int[][] sum;

    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N][N];
        open = new boolean[N][N];
        sum = new int[N][N];

        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<N;j++){
                if(tmp.charAt(j)=='1'){
                    open[i][j] = true;
                }
            }
            Arrays.fill(sum[i], Integer.MAX_VALUE);
        }

        

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,0));
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        answer = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node tmp = queue.poll();   
            
            if(tmp.x ==N-1 && tmp.y ==N-1){
                if(tmp.count<answer){
                    answer = tmp.count;                    
                }
                continue;
            }

            // 방문 했어도 count가 낮으면 계속 시도
            if(visited[tmp.x][tmp.y]){
                if(tmp.count>=sum[tmp.x][tmp.y]){
                    continue;
                }
            }

            // System.out.println(tmp.x+" "+tmp.y+" "+tmp.count);
            visited[tmp.x][tmp.y]=true;
            sum[tmp.x][tmp.y] = tmp.count;

            for(int i=0;i<4;i++){
                int tmpX = tmp.x+dx[i];
                int tmpY = tmp.y+dy[i];
                if(tmpX<0 || tmpX>=N || tmpY<0 || tmpY>=N){
                    continue;
                }
                int count = open[tmpX][tmpY] ? tmp.count: tmp.count+1;
                queue.add(new Node(tmpX, tmpY, count));
            }

        }

        System.out.println(answer);
    }

    

    public static class Node{
        int x;
        int y;
        int count;

        Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

        // implements Comparable<Node>

        // @Override
        // public int compareTo(Node n){
        //     return Long.compare(this.distance, n.distance);
        // }
    }


}
