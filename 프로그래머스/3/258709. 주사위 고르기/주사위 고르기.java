import java.io.*;
import java.util.*;


class Solution {
      
    public int n;
    public boolean[] visited;
    
    public int[] best;
    public int max;
    
    public int[][] dice;
    
    
    
    public void dfs2(int cnt, int sum, int[] list, List<Integer> result){
        
        if(cnt==n/2){
            // System.out.println(sum);
            
            result.add(sum);
            return;
        }
        
        for(int i=0;i<6;i++){
            dfs2(cnt+1, sum+dice[list[cnt]][i], list, result);
        }
        
        
    }    
    public List<Integer> makeSum(int[] list){
        
        List<Integer> result = new ArrayList<>();
        
        dfs2(0,0,list,result);
        
        return result;
    }
    
    public int caculate(int[] list, int[] opposite){
        int result = 0;
        
        List<Integer> a = makeSum(list);
        List<Integer> b = makeSum(opposite);
        
        Collections.sort(b);
        
        
        for(Integer value : a){
            
            int left = 0;
            int right = b.size()-1;
            
            int mid = 0; 
            while(left<=right){
                mid = (left+right)/2;
                
                if(value==b.get(mid)){
                    break;
                }
                else if(value<b.get(mid)){
                    right = mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            // System.out.println(mid+ " "+value);
            while(true){
                if(mid<=0){
                    break;
                }
                
                if(b.get(mid)<value){
                    break;
                }
                mid--;
            }
            // System.out.println(mid +" "+b.get(mid));
            result+=mid+1;
        }
        
        // System.out.println(result);
        return result;
    }
    
    public int[] getOpposite(int[] list){
        
        int[] result = new int[list.length];
        int idx=0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                result[idx++] = i;
            }
        }
        
        return result;
    }
    
    public void print(int[] list){
        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
    public void copy(int[] source, int[] dest){
        for(int i=0;i<dest.length;i++){
            dest[i] = source[i];
        }
    }
    public void dfs(int cnt, int k, int[] list){
        
        // System.out.println(cnt+" "+k);
        
        if(cnt==n/2){
            // System.out.println("출발");
            int[] opposite = getOpposite(list);
            int sum = caculate(list,opposite);
            
        
            // System.out.println();
            if(sum>max){
                print(list);
                System.out.println(sum);
                max = sum;
                copy(list,best);
            }
            return ;
        }

        
        for(int i=k+1;i<n;i++){
            list[cnt] = i;
            visited[i] = true;
            
            dfs(cnt+1, i, list);
            visited[i] = false;
        }
        
    }
    
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        max = 0;
        this.dice = dice;
        visited= new boolean[dice.length];
        
        best = new int[n/2];
        
        for(int i=0;i<n;i++){
            visited = new boolean[n];
            int[] list = new int[n/2];
            
            list[0] = i;
            visited[i] = true;

            dfs(1,i,list);
            visited[i] = false;
        }
        
        
        for(int i=0;i<best.length;i++){
            best[i]++;
        }
        return best;
    }
}