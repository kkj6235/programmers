import java.io.*;
import java.util.*;

class Solution {
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[0].length;j++){
                
                int tmp = 0;
                for(int k=0;k<arr1[0].length;k++){
                   tmp+=arr1[i][k]*arr2[k][j]; 
                }
                answer[i][j] = tmp;
                // answer[i][j] = arr1[i][j]
            }
        }       
        
        
        return answer;
    }
}