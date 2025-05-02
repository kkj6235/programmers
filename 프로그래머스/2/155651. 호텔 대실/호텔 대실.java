import java.io.*;
import java.util.*;


class Solution {
    
    public int getTime(String time){

        String[] strs = time.split(":");
       
        return Integer.parseInt(strs[0])*60+ Integer.parseInt(strs[1]);
    }
    
    public int solution(String[][] book_time) {
        
        int answer = 0;
        
        // 정렬..
        Arrays.sort(book_time, (a,b)->{
            
            if(a[0]!=b[0]){
                return a[0].compareTo(b[0]);
            }
            
            return a[1].compareTo(b[1]);
        });
        
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for(int i=0;i<book_time.length;i++){
            
                        
            int start = getTime(book_time[i][0]);
            int end = getTime(book_time[i][1]);
            
            
            if(rooms.isEmpty()){
                rooms.add(end+10);
                continue;
            }
            
            
            if(rooms.peek()<=start){
                rooms.poll();
            }
                
            // 새로 생성
            rooms.add(end+10);
            
            
        }
        
        return rooms.size();
    }
}