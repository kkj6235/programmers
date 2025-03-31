import java.io.*;
import java.util.*;


class Solution {
    
    public static Node[] current;
    public static int[][] map;
    public static boolean[][] visit;
    public static int answer;
    public static int count;
    
    public void print(){
        for(int i=0;i<current.length;i++){
            System.out.println(current[i].x +" "+current[i].y);
        }
    }
    public void check(){
        // 충돌여부 확인하고 answer 올리세유
        HashMap<String, Integer> tmp = new HashMap<>();
        
        
        for(int i=0;i<current.length;i++){
            if(current[i].delete){
                continue;
            }
            
            if(map[current[i].x][current[i].y]>1 && tmp.get(current[i].x+" "+current[i].y)==null){
                tmp.put(current[i].x+" "+current[i].y,1);
                // System.out.println(i+" "+current[i].x + " "+current[i].y);
                answer++;
            }
        }

    }
    
    public void move(int[][] points, int[][] routes){
        
        map = new int[101][101];
        
        for(int i=0;i<routes.length;i++){
            
            if(current[i].delete){
                continue;
            }
            
            // 마지막으로 도착한 지점 알기
            int j=0;
            
            for(j=0;j<routes[0].length;j++){
                if(!visit[i][j]){
                    break;
                }
            }
            if(j==routes[0].length){
                continue;
            }
            
            int tmp = routes[i][j];
            
            
            // delete는 j가 마지막일때만 하는거야 count도 그렇고..
            
            if(current[i].x == points[tmp-1][0] && current[i].y == points[tmp-1][1]){
                visit[i][j] = true;
                if(j==routes[0].length-1){
                    count++;
                    current[i].delete = true;
                    continue;
                }
                tmp = routes[i][j+1];
            }
            

            
            if(current[i].x!= points[tmp-1][0]){
                // x부터 이동
                if(current[i].x < points[tmp-1][0]){
                    current[i].x++;                
                }    
                else{
                    current[i].x--;
                }
            }
            else{
                // y만 이동
                if(current[i].y < points[tmp-1][1]){
                    current[i].y++;                
                }    
                else{
                    current[i].y--;
                }
            }
            
            // 이동 후 도착했는지 검사
            // if(current[i].x == points[tmp-1][0] && current[i].y == points[tmp-1][1]){
            //     count++;
            //     current[i].delete = true;
            //     continue;
            // }

            map[current[i].x][current[i].y]++;            
            
        }
        
    }
    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        count = 0;
        current = new Node[routes.length];
        visit = new boolean[routes.length][routes[0].length];
        map = new int[101][101];
        
        for(int i=0;i<routes.length;i++){
            int start = routes[i][0];
            current[i] = new Node(points[start-1][0], points[start-1][1]);
            visit[i][0] = true;
            map[current[i].x][current[i].y]++;
        }
        
        while(count<routes.length){
            // 충돌 여부 검사

            check();
            // print();
            // System.out.println();
            

            // 1단계 씩 이동
            move(points,routes);
        }
        
        return answer;
    }
    
    
    public class Node{
        int x;
        int y;
        boolean delete;
        
        Node(int x,int y){
            this.x = x;
            this.y = y;
            this.delete =false;
        }
    }
}