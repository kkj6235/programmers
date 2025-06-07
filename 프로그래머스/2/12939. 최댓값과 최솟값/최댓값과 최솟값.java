import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String s) {
        String answer = "";
        
        
        StringTokenizer st =  new StringTokenizer(s);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // st.hasMoreTokens();
        while(st.hasMoreTokens()){
            
            int tmp = Integer.parseInt(st.nextToken());
            
            max = Math.max(max, tmp);
            min = Math.min(min,tmp);
        }
        
        System.out.println(max);
        System.out.println(min);
        
        answer = min+" "+max;
        return answer;
    }
}