// knapsack
import java.io.*;
import java.util.*;


class Solution {
    
    public static boolean[][][] visited;
    public static int N,M;
    public static int result;
    public static int[][] Info;
    
    public void dfs(int cnt, int a,int b){
        
        if(a>=N || b>=M){
            return ;
        }
        if(cnt==visited.length){
            result = Math.min(a,result);
            return ;
        }
        
        
        if(visited[cnt][a][b]){
            return ;
        }
        visited[cnt][a][b]= true;
        
        dfs(cnt+1, a+Info[cnt][0],b);
        dfs(cnt+1, a, b+Info[cnt][1]);       
        
        
    }
    public int solution(int[][] info, int n, int m) {
        
        N = n;
        M = m;
        Info = info;
        result = Integer.MAX_VALUE;
        
        visited = new boolean[info.length][n+1][m+1];
        

        dfs(0,0,0);
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
    
}