import java.io.*;
import java.util.*;


/*
0 1 1 1 2 2

*/
class Solution {
    
    public int n, result;
    public boolean[] visited;
    public List<Integer> list;
    public String[] minerals;
    public int[][] grid = {{1,1,1},{5,1,1},{25,5,1}};
    
    public int getFatigue(int start, int pick){
        
        
        int answer = 0;
        
        int en = Math.min(n, start+5);
        
        for(int i=start;i<en;i++){
            
            if(minerals[i].equals("diamond")){
                answer+=grid[pick][0];
            }
            else if(minerals[i].equals("iron")){
                answer+=grid[pick][1];
            }
            else{
                answer+=grid[pick][2];
            }
        }
        
        return answer;
    }
    public void dfs(int cnt, int sum, int pick){
        
        if(result<=sum){
            return ;
        }
        
        // 곡괭이가 남는경우
        if(cnt*5>n){     
            result = Math.min(result, sum);
            return ;
        } 
        
        int fatigue= getFatigue(cnt*5, pick);         
     
        boolean flag = false;
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                flag=true;
                visited[i]= true;
                dfs(cnt+1, sum+fatigue, list.get(i));
                visited[i] = false;
            }
        }
        
        if(!flag){
            result = Math.min(result, sum+fatigue);
            return ;
        }
    
        
    }
    
    public int solution(int[] picks, String[] minerals) {

        n = minerals.length;
        result = Integer.MAX_VALUE;
        this.minerals = minerals;
        

        list = new ArrayList<>();
        
        
        // 곡괭이 펼치기
        for(int i=0;i<picks.length;i++){
            for(int j=0;j<picks[i];j++){
                list.add(i);
            }
        }
        visited = new boolean[list.size()];
        
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                visited[i]= true;
                dfs(0, 0, list.get(i));
                visited[i] = false;
            }
        }
        
        return result;
    }
}