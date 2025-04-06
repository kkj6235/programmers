import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
            
        // 
        int answer = 0;
        
        Arrays.sort(targets, (a,b)->{
            
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }
            
            return Integer.compare(a[0],b[0]);
        });
        
        
//           print(targets);
//         System.out.println();
        
        int e = targets[0][1];
        answer++;
        
        for(int i=1;i<targets.length;i++){
            
            int s = targets[i][0];
            
            // System.out.println(e);
            if(s>=e){
                e = targets[i][1];
                answer++;
                // System.out.println(targets[i][0]+","+targets[i][1]);
            }

        }
      
        
        
        
        
        return answer;
    }
    public void print(int[][] targets){
        for(int i=0;i<targets.length;i++){
            System.out.println(targets[i][0]+","+targets[i][1]);
        }
    }
}