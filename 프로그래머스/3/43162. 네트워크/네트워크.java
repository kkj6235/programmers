import java.io.*;
import java.util.*;

class Solution {
    public boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[computers.length];
        
        
        for(int i=0;i<computers.length;i++){
            if(visited[i]){
                continue;
            }
            
            Queue<Integer> queue = new LinkedList<>();
            
            queue.add(i);
            
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                
                if(visited[tmp]){
                    continue;
                }
                visited[tmp]=true;
                
                for(int j=0;j<computers[0].length;j++){
                    if(tmp==j){
                        continue;
                    }
                    
                    if(computers[tmp][j]==1){
                        queue.add(j);    
                    }
                }
            }
            
            answer++;
            
        }
        return answer;
    }
}