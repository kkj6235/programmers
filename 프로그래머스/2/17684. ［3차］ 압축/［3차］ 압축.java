import java.io.*;
import java.util.*;

class Solution {

    public Map<String, Integer> map;
    public int cnt;
    
    public boolean check(String sub){
        if(map.get(sub)!=null){
            return true;
        }
        return false;
    }
    
    public void putSubstring(String tmp){
        cnt++;
        map.put(tmp, cnt);
    }
    
    public List<Integer> solution(String msg) {
        
        map = new HashMap<>();
        cnt = 0;
        
        List<Integer> answer = new ArrayList<>();
        
        for(char i = 'A'; i<='Z'; i++){
            putSubstring(String.valueOf(i));
        }
        
        // System.out.println(msg.length());
        for(int i=0;i<msg.length();){
            int j = i+1;
            
            int last = map.get(msg.substring(i,j));
            for(j=i+1;j<msg.length();j++){
                
                if(!check(msg.substring(i,j+1))){
                    putSubstring(msg.substring(i,j+1));
                    // System.out.println(msg.substring(i,j));
                    // last = map.get(msg.substring(i,j));
                    break;
                }
                else{
                    last = map.get(msg.substring(i,j+1));
                }
            }
            // answer.add(map.get(msg.substring(i,j)));
            answer.add(last);
            i = j;
            // System.out.println(i);
        }
        
        return answer;
    }
    
}