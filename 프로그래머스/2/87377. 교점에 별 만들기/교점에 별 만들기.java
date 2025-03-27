import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        // Set으로 바꿔야할수도 있음
        HashSet<String> hs = new HashSet<>();
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        
        int n = line.length;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                
                long A = line[i][0];
                long B = line[i][1];
                long C = line[j][0];
                long D = line[j][1];
                long E = line[i][2];
                long F = line[j][2];
                
                if((A*D-B*C)==0){
                    continue;
                }
                
                if((B*F-E*D)%(A*D-B*C)!=0 || (E*C-A*F)%(A*D-B*C)!=0){
                    continue;
                }
                long x = (B*F-E*D)/(A*D-B*C);
                long y = (E*C-A*F)/(A*D-B*C);
               
                minX = Math.min(x,minX);
                maxX = Math.max(x,maxX);
                minY = Math.min(y,minY);
                maxY = Math.max(y,maxY);
                hs.add(x+","+y); 
            }
        }
        
        
        if(hs.size()==1){
            String[] answer = {"*"};
            return answer;
        } 

        // 최대 최소 길이 정하기
        int xL = (int)(maxX-minX+1);
        int yL = (int)(maxY-minY+1);
        
        String[] answer = new String[yL];
        
        // System.out.println(xL+" "+yL);
        // System.out.println(minX+" "+maxX+" "+minY+" "+maxY);
        for(int i=0;i<yL;i++){
            
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<xL;j++){
                sb.append(".");
            }
            answer[i]= sb.toString();
        }
        
        Iterator<String> it = hs.iterator();
        
        while(it.hasNext()){
            String[] strs = it.next().split(",");

            // System.out.println(strs[0]+" "+strs[1]);
            
            int x = (int)(Long.parseLong(strs[0])-minX);
            int y = (int)(Long.parseLong(strs[1])-minY);
            
            // System.out.println(strs[0]+" "+strs[1]+" "+x+" "+y);
            StringBuilder sb = new StringBuilder(answer[yL-y-1]);
            sb.setCharAt(x, '*');
            
            answer[yL-y-1] = sb.toString();
        }
        
        // for(int i=0;i<yL;i++){
        //     for(int j=0;j<xL;j++){
        //         String tmp = answer[i];
        //         System.out.print(tmp.charAt(j)+" ");
        //     }
        //     System.out.println();
        // }
    
        return answer;
    }
    
    
    // 절댓값 최대 찾기~! comparable 써야할듯 우선순위 큐 써서
    // 아니면 정렬 한번해도되고
    class Point{
        int x;
        int y;
        Point (int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}