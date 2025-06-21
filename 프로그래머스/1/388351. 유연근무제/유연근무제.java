import java.io.*;
import java.util.*;


class Solution {
    public static int answer;
    public static boolean[] delete;
    public static int[] endTimes;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
            
        answer = schedules.length;
        delete = new boolean[schedules.length];
        endTimes = new int[schedules.length];
        for(int i=0;i<schedules.length;i++){

            endTimes[i] = schedules[i]+10;
            
            if(endTimes[i]%100 >= 60){
                endTimes[i]+=40;
            }
        }
        
        
        for(int i=0;i<timelogs[0].length;i++){
            if(startday==6){
                startday = 1;
                i++;
                continue;
            }
            else if(startday==7){
                startday = 1;
                continue;
            }
            
            for(int j=0;j<timelogs.length;j++){
                if(delete[j]){
                    continue;
                }
                if(timelogs[j][i]>endTimes[j]){
                    delete[j] = true;
                    answer--;
                }
                
            }
            startday++;
            
        }
        
        
        return answer;
    }
}