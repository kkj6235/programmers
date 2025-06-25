import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(String[] wallpaper) {
        
        
        // boolean[][] coordinate = new boolean[wallpaper.length][wallpaper[0].length()];
        
        int u=0,d=0, l=0,r=0;
        boolean flag= false;
        for(int i=0;i<wallpaper.length;i++){    
            for(int j=0;j<wallpaper[i].length();j++){
                
                if(wallpaper[i].charAt(j)=='#'){
                    
                    if(!flag){
                        u = i;
                        d = i;
                        l = j;
                        r = j;
                        flag= true;
                    } 
                    
                    d=i;
                    if(j<l){
                        l=j;
                    }
                    if(r<j){
                        r=j;
                    }
                    
                }
                    
                
            }
            
        }
        
        System.out.println(u+" "+l+" "+(d+1)+" "+(r+1));
        
        // 나중에 +1만 하면 되는거 아냐?

        
        int[] answer = {u, l, d+1, r+1};
        
        
        return answer;
    }
}