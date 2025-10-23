import java.io.*;
import java.util.*;

class Solution {
    
    
    // 우선순위 먼저 찾자!
    // d l r u 순서..
    
    
    int[] dx ={1,0,0,-1};
    int[] dy={0,-1,1,0};
    char[] ds = {'d','l','r','u'};
    
    public boolean overlap(int a, int b){
        if(a<=0 || a>n || b<=0 || b>m){
            return false;
        }
        
        return true;
    }
    
    public void dfs(int cnt, int x, int y, String str){
        
        if(flag){
            return ;
        }
        
        if(cnt==k){
            if(x==r && y==c){
                // 성공!
                System.out.println(str);
                
                flag = true;
                answer = str;
            }
            
            return ;
        }
        
        if(visited[cnt][x][y]){
            return ;
        }
        visited[cnt][x][y] = true;
        
        for(int i=0;i<4;i++){
            int newx= dx[i]+x;
            int newy=dy[i]+y;
            
            if(overlap(newx,newy)){
                // System.out.println(newx+","+newy);
                dfs(cnt+1, newx, newy, new String(str+ds[i]));
            }
        }
            
    }
    boolean[][][] visited;
    boolean flag;
    int n,m,r,c,k;
    String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        visited= new boolean[k][n+1][m+1];
        
        this.n=n;
        this.m=m;
        
        this.r=r;
        this.c=c;
        this.k=k;
        flag = false;
        

       dfs(0,x,y,"");     
        
        // 모든 경우의수 다 돌았는데 없어? 
        if(flag){
            return answer;
        }
        
        return "impossible";
    }
}