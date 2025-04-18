import java.io.*;
import java.util.*;

class Solution {
    

    public static boolean[][] open;
    public static boolean[][] status; 
    public static int count;
    public static int n,m;
    

    public void bfs(){
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        open = new boolean[n+2][m+2];
        
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(0,0));
        open[0][0] = true;
        
        while(!queue.isEmpty()){
            Node tmp  = queue.poll();
            for(int i=0;i<4;i++){
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];
                
                if(x<0 || y<0 || x>=n+2 || y>=m+2){
                    continue;
                }
                if(open[x][y] || !status[x][y]){
                    continue;
                }
                open[x][y] = true;
                queue.add(new Node(x,y));
            }
            
            
        }
        
        
    }
    
    public boolean check(int x, int y){
        int[] dx ={1,-1,0,0};
        int[] dy ={0,0,1,-1};
        
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(open[nx][ny]){
                return true;
            }
        }
        return false;
    }
    public void print(){
        for(int i=0;i<n+2;i++){
            for(int j=0;j<m+2;j++){
                System.out.print(open[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int solution(String[] storage, String[] requests) {
        

        n = storage.length;
        m = storage[0].length();
        status = new boolean[n+2][m+2];
        count = n*m;
        
        Arrays.fill(status[0], true);
        Arrays.fill(status[n+1], true);
        
        for(int i=1;i<=n;i++){
            status[i][0] = true;
            status[i][m+1] = true;
        }
        
        
        
        for(String req : requests){
            
            bfs();
            // print();
            if(req.length()==2){
                for(int i=0;i<storage.length;i++){
                    for(int j=0;j<storage[0].length();j++){
                        if(storage[i].charAt(j)==req.charAt(0) && !status[i+1][j+1]){
                                status[i+1][j+1] = true; 
                                count--;
                        }
                    }
                }                
            }
            else{
               for(int i=0;i<storage.length;i++){
                    for(int j=0;j<storage[0].length();j++){
                        if(storage[i].charAt(j)==req.charAt(0)){
                            // System.out.println((i+1)+" "+(j+1));
                            // System.out.println(check(i+1,j+1));
                            if(check(i+1,j+1) && !status[i+1][j+1]){
                                // System.out.println(i+" "+j);
                                status[i+1][j+1] = true;
                                count--;
                            }
                        }
                    }
                }                                 
            }
            // System.out.println(count);
            
        }
        
        
        
        return count;
    }
    
    
    public static class Node{
        int x;
        int y;
        
        Node(int x, int y){
            this.x =x;
            this.y=y;
        }
    }
    

}