import java.io.*;
import java.util.*;


class Solution {
    
    public int[] solution(int[] sequence, int k) {
        
        // 누적합 구하기
        int[] answer = new int[2];
        int n = sequence.length;
        long[] sum = new long[n+1];
        
        
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1]+sequence[i-1];
            // System.out.println(sum[i]);
        }
        
        
        
        try{
            for(int gap=1;gap<=n;gap++){

                if(sum[n]-sum[n-gap]<k){
                    continue;
                }
                for(int st=0;st<n;st++){
                    int en = st+gap;
                    if(en>n){
                        break;
                    }
                    // System.out.println(st+" "+en);
                    if((sum[en]-sum[st])>k){
                        break;
                    }
                    else if(sum[en]-sum[st]==k){
                        // System.out.println("도착");
                        answer[0] = st;
                        answer[1] = en-1;
                        return answer;
                    }
                    
                }
            }            
        }
        catch(Exception e){
            
        }

        
        
        return answer;
    }
}