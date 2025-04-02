import java.io.*;
import java.util.*;

class Solution {
    
    boolean[] finished;
    int[] deliveries;
    int[] pickups;

    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        finished = new boolean[n];
        this.deliveries = deliveries;
        this.pickups = pickups;
        // 앞에서부터 하나씩 가져오기
        
        int dIdx = n-1;
        int pIdx = n-1;
        int delivery = 0;
        int pickup = 0;
        
        
        boolean flag= false;
        while(dIdx>=0 && pIdx>=0){
            
            if(deliveries[dIdx]!=0 && delivery<cap){
                
                int tmp = Math.min(deliveries[dIdx], cap-delivery);
                delivery+=tmp;
                deliveries[dIdx]-=tmp;
                flag=true;
            }
            
            if(pickups[pIdx]!=0 && pickup<cap){
                int tmp = Math.min(pickups[pIdx], cap-pickup);
                pickup+=tmp;
                pickups[pIdx]-=tmp;
                flag=true;
            }
            
            while(dIdx>=0 && deliveries[dIdx]==0){
                dIdx--;
            }
            
            while(pIdx>=0 && pickups[pIdx]==0){
                pIdx--;
            }
            
            if(delivery==cap && pickup==cap){
                
                delivery = 0;
                pickup=0;
                
                answer+=(Math.max(dIdx, pIdx)+1)*2;
                // System.out.println("도착 "+answer+" "+dIdx+" "+pIdx);
            }
            
            
            // System.out.println(delivery+" "+pickup+" "+dIdx+" "+pIdx);
        }
        
        
        while(dIdx>=0){
            // System.out.println("d가 남았어요");
            // 남은거 제거
            if(deliveries[dIdx]!=0 && delivery<cap){
                
                int tmp = Math.min(deliveries[dIdx], cap-delivery);
                delivery+=tmp;
                deliveries[dIdx]-=tmp;
                flag=true;
            }
            
            while(dIdx>=0 && deliveries[dIdx]==0){
                dIdx--;
            }

            if(delivery==cap){
                
                delivery = 0;
                
                answer+=(dIdx+1)*2;
                // System.out.println("도착 "+answer+" "+dIdx+" "+pIdx);
            }
        
        }

        while(pIdx>=0){
            // System.out.println("p가 남았어요");
            if(pickups[pIdx]!=0 && pickup<cap){
                int tmp = Math.min(pickups[pIdx], cap-pickup);
                pickup+=tmp;
                pickups[pIdx]-=tmp;
                flag=true;
            }
            

            
            while(pIdx>=0 &&pickups[pIdx]==0){
                pIdx--;
            }
            
            if(pickup==cap){
                
                pickup=0;
                
                answer+=(pIdx+1)*2;
                // System.out.println("도착 "+answer+" "+dIdx+" "+pIdx);
            }

        }
          
        if(flag){
            answer+=n*2;
        }
        return answer;
    }
}