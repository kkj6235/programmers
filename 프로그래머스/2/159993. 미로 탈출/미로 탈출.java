import java.io.*;
import java.util.*;

class Solution {
    
    public int[][] grid;
    public int[][] visited;
    public int n,m;
    public Point start,end,lever;
    public int[] dx={-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    
    public boolean overlap(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m){
            return false;
        }
        if(grid[x][y]==-1){
            return false;
        }
        if(visited[x][y]!=0){
            return false;
        }          

        
        return true;
    }
    public int solution(String[] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length();
        
        grid = new int[n][m];
        visited = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char tmp = maps[i].charAt(j);
                
                if(tmp=='X'){
                    grid[i][j]=-1;                    
                }
                else if(tmp=='S'){
                    start = new Point(i,j);
                }
                else if(tmp=='E'){
                    end = new Point(i,j);
                }
                else if(tmp=='L'){
                    lever = new Point(i,j);
                }
                
            }
        }
        
        
        int a = -1,b=-1;
        // bfs로 lever 찾기
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(start);
        
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            
            // System.out.println(tmp.x+","+tmp.y+" "+visited[tmp.x][tmp.y]);
            if(tmp.x==lever.x && tmp.y==lever.y){
                // 도착
                a = visited[tmp.x][tmp.y];
                break;
            }
            for(int i=0;i<4;i++){
                int newx=dx[i]+tmp.x;
                int newy=dy[i]+tmp.y;
                if(overlap(newx,newy)){
                    visited[newx][newy]= visited[tmp.x][tmp.y]+1;
                    queue.add(new Point(newx,newy));
                }
            }
            
        }
        
        if(a==-1){
            return -1;
        }
        // bfs로 end 찾기
        
        visited = new int[n][m];
        queue = new LinkedList<>();
        queue.add(lever);
        
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            
            // System.out.println(tmp.x+","+tmp.y+" "+visited[tmp.x][tmp.y]);
            if(tmp.x==end.x && tmp.y==end.y){
                // 도착
                b = visited[tmp.x][tmp.y];
                break;
            }
            for(int i=0;i<4;i++){
                int newx=dx[i]+tmp.x;
                int newy=dy[i]+tmp.y;
                if(overlap(newx,newy)){
                    visited[newx][newy]= visited[tmp.x][tmp.y]+1;
                    queue.add(new Point(newx,newy));
                }
            }
            
            
        }
        
        if(b==-1){
            return -1;
        }
        
        
        return a+b;
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