import java.io.*;
import java.util.*;

class Solution {
    
    public int stringToMin(String s){
        String[] tmp = s.split(":");
        return Integer.parseInt(tmp[0]) *60*60 + Integer.parseInt(tmp[1])*60 + Integer.parseInt(tmp[2]);
    }
    
    public String minToString(int i){
        int hours = i /3600;
        i %= 3600;
        int minutes = i / 60;
        int seconds = i % 60;
        
        String h =  hours/10==0 ? "0" + String.valueOf(hours): String.valueOf(hours);
        String m = minutes/10 ==0 ? "0" + String.valueOf(minutes) : String.valueOf(minutes);
        String s = seconds/10==0 ? "0"+ String.valueOf(seconds) : String.valueOf(seconds);

        return h+":"+m+":"+s;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
          
        int len = stringToMin(play_time);
        int[] ad = new int[len+1];
        
        // ad[i] 자리에 현재 광고가 몇개있는지 체크
        for(int i=0;i<logs.length;i++){
            String[] tmp = logs[i].split("-");
            int start = stringToMin(tmp[0]);
            int end = stringToMin(tmp[1]);
            
            for(int j=start;j<end;j++){
                ad[j]++;
            }
        }
        
        // 누적합으로 그 구간에 가장 높은 sum 값을 가진 idx 찾기일듯!
        int ad_len = stringToMin(adv_time);
        long maxSum = 0;
        int maxIdx=0;
        
        for(int i=0;i<ad_len;i++){
            maxSum +=ad[i];    
        }
        
        // 슬라이딩 윈도우 시작
        // 앞에꺼 더하고 그 뒤에꺼 빼고
        // max_sum보다 큰지 확인 크면 그 idx로 초기화
        long sum = maxSum;
        for(int i=ad_len;i<=len;i++){
            
            sum-=ad[i-ad_len];
            sum+=ad[i];
            if(sum>maxSum){
                maxSum=sum;
                maxIdx=i-ad_len+1;
            }
        }
                
        
        return minToString(maxIdx);
    }
}