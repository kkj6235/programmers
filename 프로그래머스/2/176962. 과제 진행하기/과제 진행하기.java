import java.io.*;
import java.util.*;

class Solution {
    
    public int getMinute(String time){
        
        String[] tmp = time.split(":");
        
        return Integer.parseInt(tmp[0])*60+ Integer.parseInt(tmp[1]);
    }
    public List<String> solution(String[][] plans) {
        List<String> answer= new ArrayList<>();
        
        Stack<Plan> stack = new Stack<>();
        
        Arrays.sort(plans, (a,b)->{
            return a[1].compareTo(b[1]); 
        });
        
        int n = plans.length;

        int cnt = getMinute(plans[0][1]);
        
        stack.add(new Plan(0, Integer.parseInt(plans[0][2])));
        
        for(int i=1;i<n;i++){
            
            int remain = getMinute(plans[i][1])-cnt;
            
            
            
            // 적은 경우 많은 경우 확인
            while(!stack.isEmpty() && remain>0){
                
                Plan p = stack.pop();
                System.out.println(plans[p.idx][0]+" "+p.min);
                remain -= p.min;
                
                if(remain<0){
                    p.min = -remain;
                    System.out.println(plans[p.idx][0]+ " 다시 저장 "+p.min);
                    stack.add(p);
                    break;
                }
                // System.out.println(plans[p.idx][0]);
                answer.add(plans[p.idx][0]);
            } 
            
            stack.add(new Plan(i, Integer.parseInt(plans[i][2])));
            // 바로 다음 시작..
            
            cnt = getMinute(plans[i][1]);
            // System.out.println(cnt);
        }

        
        // 남은 스택 처리
        while(!stack.isEmpty()){
            Plan p = stack.pop();
            // System.out.println(plans[p.idx][0]);
            answer.add(plans[p.idx][0]);
        }
        
        return answer;
    }
    
    class Plan{
        int idx;
        int min;
        
        Plan(int idx, int min){
            this.idx=idx;
            this.min=min;
        }
    }
}