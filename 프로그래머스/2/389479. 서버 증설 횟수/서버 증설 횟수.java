import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        
        List<Integer> server = new ArrayList<>(); 
        
        for(int i=0;i<players.length;i++){
            
            for(int j=0;j<server.size();){
                int updated = server.get(j) - 1;
                if (updated <= 0) {
                    server.remove(j);  
                } else {
                    server.set(j, updated);
                    j++;  
                }
            
            }
            
            if(players[i] / m > server.size()){
                
                int tmp = players[i]/ m - server.size();
                
                for(int j=0;j<tmp;j++){
                    server.add(k);
                    answer++;
                }
                
            }
            
        
        }
        return answer;
    }
}