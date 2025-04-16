import java.io.*;
import java.util.*;

class Solution {
    
    
    public int[][] question;
    public int[] answer;
    public int n;
    public int result;
    
    public boolean check(int[] list){
        // list와 question 비교..
        
        // System.out.println(list[0]);
        for(int i=0;i<answer.length;i++){
               
            int j=0,k=0;
            int cnt = 0;
            
            while(j<list.length && k<question[i].length){
                
                if(list[j]==question[i][k]){
                    cnt++;
                    j++;
                    k++;
                }
                else if(list[j]<question[i][k]){
                    j++;
                }
                else{
                    k++;
                }
            }
            
            if(cnt!=answer[i]){
                return false;
            }
            
        }
        // System.out.println("어서와");
        return true;
    }
    public void dfs(int cnt, int k, int[] list){
        
        // if(k>n){
        //     return ;
        // }
        if(cnt==5){
            if(check(list)){
                // System.out.println("어서와");
                result++;
                // print(list);
            }
            return ; 
        }
        
        
        for(int i=k;i<=n;i++){
            list[cnt]=i;  
            dfs(cnt+1,i+1,list); 
        }
    }
    
    public void print(int[] list){
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        
        question = q;
        answer = ans;
        this.n=n;
        result=0;
        
        dfs(0, 1, new int[5]);
        return result;
    }
}