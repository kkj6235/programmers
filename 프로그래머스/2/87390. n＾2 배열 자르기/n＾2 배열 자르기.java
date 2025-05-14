import java.io.*;
import java.util.*;

class Solution {
    
    public long caculate(long idx, int n){
        
        // int a = idx/n;
        // int b = idx%n;
        long a = idx / n;
        long b = idx % n;

        // if(a==0){
        //     return b+1;
        // }
        if(a>=b){
            return a+1;
        }
        return b+1;
        /*
        0 2 -> 
        1 0 -> a>=b
        1 1 -> a>=b
        1 2 -> a<b -> b+1
        */
        
        // return 1;
    }
    
    
    public long[] solution(int n, long left, long right) {
        long[] answer = {};
        answer = new long[(int)(right-left)+1];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = caculate(left+i, n);
        }
        
        return answer;
    }
}