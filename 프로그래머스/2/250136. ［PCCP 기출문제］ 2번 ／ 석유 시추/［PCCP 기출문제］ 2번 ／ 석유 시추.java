import java.io.*;
import java.util.*;


class Solution {

    public int n,m, idx;
    public int[][] grid;
    public int[][] land;
    
    public boolean[][] visited;
    public List<Integer> list;
    
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    
    public boolean overlap(int x, int y){
        if(x<0 || x>=n || y<0|| y>=m){
            return false;
        }
        
        if(land[x][y]==0){
            return false;
        }
        return true;
    }
    public int bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        int cnt = 0;

        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            // System.out.println("어서와");
            if(visited[tmp.x][tmp.y]){
                continue;
            }
            visited[tmp.x][tmp.y]= true;
            // System.out.println("어서와");
            grid[tmp.x][tmp.y]=idx;
            cnt++;
            
            for(int i=0;i<4;i++){
                int newx= tmp.x+dx[i];
                int newy = tmp.y+dy[i];
                if(overlap(newx,newy)){
                    queue.add(new Point(newx,newy));
                }
            }   
        }
        
        return cnt;
        
    }
    public int solution(int[][] land) {
        
        this.land=land;
        n = land.length;
        m = land[0].length;
        visited= new boolean[n][m];
        grid = new int[n][m];
        list = new ArrayList<>();
        list.add(0);
        idx=1;
        
        // bfs로 영역 설정
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                
                if(visited[i][j]){
                    continue;
                }
                
                
                if(land[i][j]==1){
                    int sum = bfs(i,j);
                    list.add(sum); 
                    idx++;
                }
                
                visited[i][j]=true;
            }

        }
        
        // gridPrint();
        int answer = 0;
    
        for(int i=0;i<m;i++){
            boolean[] visited = new boolean[idx+1];
            int sum=0;
            for(int j=0;j<n;j++){
                if(grid[j][i]!=0){
                    if(!visited[grid[j][i]]){
                       sum+=list.get(grid[j][i]);
                        // System.out.println(grid[j][i]);
                       visited[grid[j][i]] = true;
                    }
                }
            }
            // System.out.println(sum);
            
            answer = Math.max(sum, answer);
            
        }
        
        
    
        return answer;
    }
    public void gridPrint(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}