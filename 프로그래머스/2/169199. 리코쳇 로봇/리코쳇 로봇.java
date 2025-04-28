import java.io.*;
import java.util.*;

class Solution {
    
    int[][] grid;
    int n,m;
    Point start, end;
    int[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public boolean overlap(int x,int y){
        
        if(x<0 || x>=n || y<0 || y>=m){
            return false;
        }
        if(grid[x][y]==-1){
            return false;
        }
        
        return true;
    }
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        grid = new int[n][m];
        visited = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i].charAt(j)=='D'){
                    grid[i][j]=-1;
                }        
                else if(board[i].charAt(j)=='R'){
                    start = new Point(i,j);
                }
                else if(board[i].charAt(j)=='G'){
                    end = new Point(i,j);
                }
            }
        }
        
        
        // end 근처에 4개 구간이 모두 -1이라면 answer은 -1
        // 혹은 장애물이 아예 없어도 불가..
        
        
        
        
        // bfs가 기본이되, 방향 정해지면 dfs로 그 방향 쭉쭉 이동~~
        
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(start);
        
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            // if(visited[tmp.x][tmp.y]!=0){
            //     continue;
            // }
            // visited[tmp.x][tmp.y] = true;
            // System.out.println(tmp.x+" "+tmp.y+" 꺼냄");
            
            if(tmp.x==end.x && tmp.y==end.y){
                // System.out.println("도착");
                // System.out.println();
                return visited[tmp.x][tmp.y];
            }
            for(int i=0;i<4;i++){
                
                int newx = tmp.x+dx[i];
                int newy = tmp.y+dy[i];
                
                if(overlap(newx,newy)){
                    while(overlap(newx,newy)){
                        newx +=dx[i];
                        newy +=dy[i];
                    }
                    newx-=dx[i];
                    newy-=dy[i];
                    
                    if(visited[newx][newy]==0){
                        // System.out.println(newx+" "+newy+" 추가 "+tmp.x+" "+tmp.y);
                        queue.add(new Point(newx,newy));
                        visited[newx][newy] = visited[tmp.x][tmp.y]+1;
                    }

                }
            }
            
        }
        
        
        
        return -1;
    }
    class Point{
        int x;
        int y;
        
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}