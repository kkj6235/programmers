import java.io.*;
import java.util.*;

public class Main {

    public static StringTokenizer st;
    public static BufferedReader br;
    public static int N,M,answer;
    public static boolean[][] visited, open;
    public static int[][] sum;
    public static Node enemy;

    public static void main(String[] args) throws IOException{

        Queue<Node> queue = new LinkedList<>();
        
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        open = new boolean[N][M];
        sum = new int[N][M];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<2;i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(i==0){
                queue.add(new Node(x-1,y-1,0));
            }
            else{
                enemy = new Node(x-1,y-1,0);
            }

        }
        
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            for(int j=0;j<M;j++){
                if(tmp.charAt(j)=='0'){
                    open[i][j] = true;
                }
            }
            Arrays.fill(sum[i], Integer.MAX_VALUE);
        }
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        answer = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node tmp = queue.poll();   
            
            // 도착점
            if(tmp.x == enemy.x && tmp.y == enemy.y){
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
                if(tmpX<0 || tmpX>=N || tmpY<0 || tmpY>=M){
                    continue;
                }
                int count = open[tmpX][tmpY] ? tmp.count: tmp.count+1;
                // if(open[tmpX][tmpY]){
                //     System.out.println(tmpX+" "+tmpY);
                // }
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
