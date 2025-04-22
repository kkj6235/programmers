import java.io.*;
import java.util.*;

class Solution {

        
    public int[] diffs,times;
    public long limit;
    
    public long check(int level){
        
        long sum=0;
        for(int i=0;i<diffs.length;i++){
            
            if(diffs[i]<=level){
                sum+=times[i];
            }
            else{
                int tmp = diffs[i]-level;
                
                sum+= tmp*(times[i-1]+times[i]) + times[i];
                
            }

        }
        
        return sum;
    }

    
    public int solution(int[] diffs, int[] times, long limit) {
        
        this.diffs=diffs;
        this.times=times;
        this.limit=limit;
        
        int a = 1;
        int b = 100000;
        
        while(a<=b){
            int level = (a+b)/2;
            long sum = check(level);
            if(sum>limit){
                // b = level-1;
                a = level+1;
            }
            else{
                // a = level+1;
                b = level-1;
            }

        }
        
        return a;
    }
}