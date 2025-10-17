import java.io.*;
import java.util.*;

class Solution {
    
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 먼저 routes 정렬
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cnt = Integer.MIN_VALUE;
        
        for(int[] route : routes){
            
            if(route[0]<=cnt && cnt<=route[1]){
               continue;     
            }
            
            cnt = route[1];
            answer++;
            
            
        }
        

        
        return answer;
    }
    

}