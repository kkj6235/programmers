import java.io.*;
import java.util.*;

class Solution {
    
    // string은 항상 숫자로 바꿔서 변환
    // 슬라이딩 윈도우인지 의심
    
    
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int answer = 0;
        int cnt = stringToMin(pos);
        int start = stringToMin(op_start);
        int end = stringToMin(op_end);
        int total_len = stringToMin(video_len);
        
        for(String command : commands){
            
            if(start<=cnt && cnt<=end){
                cnt=end;
            }
            
            if(command.equals("next")){
                cnt+=10;    
            }
            else if(command.equals("prev")){
                cnt-=10;   
            }
            
            if(cnt<0){
                cnt = 0;
            }
            if(cnt>total_len){
                cnt = total_len;
            }
            
            if(start<=cnt && cnt<=end){
                cnt=end;
            }
            

        }    
        
        return minToString(cnt);
    }
    
    
    public int stringToMin(String time){
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
    
    public String minToString(int min){
        String minute = String.valueOf(min/60);
        String second = String.valueOf(min%60);
        if(min/60 <10){
            minute = "0"+minute;
        }
        if(min%60 <10){
            second = "0"+second;
        }
        
        return minute+":"+second;
    }
}