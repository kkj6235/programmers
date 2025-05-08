import java.io.*;
import java.util.*;

class Solution {
    
    public Map<Double, Integer> map;
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        map = new HashMap<>();
        
        for(int i=weights.length-1;i>=0;i--){
            
            double a = weights[i]*1.0;
            double b = weights[i]*1.5;
            double c = weights[i]*(4.0/3.0);
            double d = weights[i]*2.0;
            
            // System.out.println(d);
            
            if(map.containsKey(a)){
                // System.out.println(a);
                answer+= map.get(a);
            }
            if(map.containsKey(b)){
                // System.out.println(a);
                answer+=map.get(b);
            }
            if(map.containsKey(c)){
                // System.out.println(a);
                answer+=map.get(c);
            }
            if(map.containsKey(d)){
                // System.out.println(a);
                answer+=map.get(d);
            }
            
            map.put(weights[i]*1.0, map.getOrDefault(a, 0)+1);
        }
        
 
        return answer;
    }
}