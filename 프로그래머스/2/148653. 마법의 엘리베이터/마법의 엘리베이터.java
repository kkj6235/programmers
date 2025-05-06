import java.io.*;
import java.util.*;


class Solution {
    public int solution(int storey) {
        
        // storey를 나누는거네..
        
        int answer = 0;

        
        int dividend = storey;
        // 반올림 
        int divisor = 10;
        
        while(dividend>0){
            int remainder = dividend%divisor;
            dividend/=10;
            
            if(remainder==5){
                
                if(dividend%10>=5){
                    answer+=(10-remainder);
                    dividend++;
                }
                else{
                    answer+=remainder;
                    
                }
            }
            else if(remainder>5){
                answer+=(10-remainder);
                dividend++;
            }
            else{
                answer+=remainder;
            }
            
        }    
        
    
        return answer;
    }
}