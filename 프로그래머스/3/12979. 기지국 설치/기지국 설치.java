import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cnt = 1;
        
        // 1. 일반적인 경우
        // 2. station[0] = cnt인 경우
        // 3. station[0] = n 인경우
        
        for(int station : stations){    
            if(cnt>=station-w && cnt<=station+w){
                // station 범위에 들어오면 pass인듯..
                cnt=station+w+1;
                continue;
            }
            int end = station-w-1;
            int quotient = (end-cnt+1)/(2*w+1);
            int remainder = (end-cnt+1)%(2*w+1);
            // System.out.println(quotient+" "+remainder);
            // 시간 복잡도를 고려했을때
            // station-w와 cnt사이 w 간격이 몇개 있는지
            answer+=quotient;
            if(remainder!=0){
                answer++;
            }
            cnt=station+w+1;
        }
        if(cnt>n){
            return answer;
        }
        
        // System.out.println("station 끝나고 남은 계산 시작");
        // station 이후.. 남은 n까지 측정..
        int quotient = (n-cnt+1)/(2*w+1);
        int remainder = (n-cnt+1)%(2*w+1);
        answer+=quotient;
        if(remainder!=0){
            answer++;
        }
        // System.out.println(quotient+" "+remainder);
        return answer;
    }
}

/*

1  5   9  13
 

*/