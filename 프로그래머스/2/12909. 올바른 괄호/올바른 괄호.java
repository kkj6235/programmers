import java.io.*;
import java.util.*;

class Solution {
    
    boolean solution(String s) {
        
        int sum=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                sum++;
            }
            else{
                sum--;
            }
            if(sum<0){
                return false;
            }
        }
        
        if(sum==0){
            return true;
        }

        return false;
    }
}