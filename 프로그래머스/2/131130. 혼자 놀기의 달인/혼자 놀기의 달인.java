import java.io.*;
import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int[] cards) {
        int answer = 1;
        int count = 0;
        int sum = 0;
        count = 0;
        visited = new boolean[cards.length];
        
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());

        
        for(int i=0;i<cards.length;i++){
            if(count==cards.length){
                break;
            }
            while(true){
            
                if(visited[i]){
                    break;
                }

                visited[i]=true;
                i = cards[i]-1;
                count++;
            }      
            
            if(i==0){
                pq.add(count);
            }
            else{
                pq.add(count-sum);
            }
            sum = count;
        }
        
        if(pq.size()<=1){
            return 0;
        }
        
        return pq.poll()*pq.poll();
    }
}