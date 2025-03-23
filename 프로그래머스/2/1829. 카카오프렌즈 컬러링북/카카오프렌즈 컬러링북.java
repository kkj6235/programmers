import java.io.*;
import java.util.*;


class Solution {
    
    boolean[][] visited;
    int[] dx ={-1,1,0,0};
    int[] dy ={0,0,-1,1};
    int m,n;
    int[][] picture;
    
    public boolean overlap(int x,int y){
        // System.out.println(x+","+y+" "+n+" "+m);
        if(x<0 || x>=m || y<0 || y>=n){
            // System.out.println("범위에서");
            return false;
        }
        
        if(visited[x][y] || picture[x][y]==0){
            // System.out.println("그외 2번");
            return false;
        }
        return true;
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        this.picture = picture;
        this.m=m;
        this.n=n;
        
        visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] || picture[i][j]==0){
                    continue;
                }
                
                // System.out.println("어서와 "+i+","+j);
                numberOfArea++;
                
                int num = picture[i][j];
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i,j));
                
                int count =0;
                while(!queue.isEmpty()){
                    Point tmp = queue.poll();
                    if(visited[tmp.x][tmp.y]){
                        continue;
                    }
                    // System.out.println("어서와2 "+tmp.x+","+tmp.y);
                    
                    count++;
                    visited[tmp.x][tmp.y] = true;
                    
                    for(int k=0;k<4;k++){
                        int newx= dx[k]+tmp.x;
                        int newy= dy[k]+tmp.y;
                        // System.out.println("어서와3 "+newx+","+newy);
                        if(overlap(newx, newy)){
                            // System.out.println("어서와4 "+newx+","+newy);
                            if(picture[newx][newy]==num){
                                queue.add(new Point(newx,newy));                        
                            }
                        }
                    }            
                }
                
                
                maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
        
        
        
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