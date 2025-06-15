import java.io.*;
import java.util.*;

class Solution {
    
    public static Map<String, Integer> map;
    public static StringTokenizer st;
    public static int[][] array;
    public static int[] giftIdx;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int length = friends.length;
        array = new int[length][length];
        map = new HashMap<>();
        giftIdx = new int[length];
        
        for(int i=0;i<length;i++){
            map.put(friends[i],i);
        }
        
        for(String gift : gifts){
            
            st = new StringTokenizer(gift);
            
            int a = map.get(st.nextToken());
            int b = map.get(st.nextToken());
            
            array[a][b]++;
            
            giftIdx[a]++;
            giftIdx[b]--;
        }

        for(int i=0;i<length;i++){
            int tmp = 0;
            for(int j=0;j<length;j++){
                if(i==j){
                    continue;
                }
                
                if(array[i][j]==array[j][i]){
                    
                    if(giftIdx[i]>giftIdx[j]){
                        tmp++;
                    }
                }
                else if(array[i][j]>array[j][i]){
                    tmp++;
                }

                
            }
            
            if(tmp>answer){
                // System.out.println(i);
                answer = tmp;
            }
            System.out.println(tmp);
        }
        
        
        return answer;
    }
}