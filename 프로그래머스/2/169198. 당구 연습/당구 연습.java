import java.io.*;
import java.util.*;

class Solution {
    

    
    /*
    
    1. x축 대칭(y=0)
    2. y축 대칭(x=0)
    3. x=m일때 대칭
    4. y=n일때 대칭
    */
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        int[] newx = {startX, -startX, 2*m-startX, startX };
        int[] newy = {-startY, startY, startY, 2*n-startY };
        

        boolean[] banned;
        for(int i=0;i<balls.length;i++){
            
            int min = Integer.MAX_VALUE;
            
            
            // ban 검사
            banned = new boolean[4];
            
            // x가 같은경우
            if(startX== balls[i][0]){
                // y가 나보다 크면  y=n 대칭 금지
                if(startY<balls[i][1]){
                    banned[3] = true;
                }
                // y가 나보다 작으면 x축 대칭 금지
                else{
                    banned[0] = true;
                }
                
            }
            
            // y가 같은경우
            if(startY == balls[i][1]){
                
                // x가 나보다 크면 x=m 대칭 금지
                if(startX<balls[i][0]){
                    banned[2] = true;
                }
                // x가 나보다 작으면 y축 대칭 금지
                else{
                    banned[1] = true;
                }
                
            }
            
            
            
            for(int j=0;j<4;j++){
                if(banned[j]){
                    continue;
                }
                int tmp = (int)Math.pow(newx[j]-balls[i][0],2) + (int)Math.pow(newy[j]-balls[i][1],2);
    
                min = Math.min(min,tmp);
            }    
            // 내 자신을 대칭 4개해
            answer[i] = min;
        }
        return answer;
    }
}
