import java.io.*;
import java.util.*;

class Solution {
    
    // 현재 행
    public static Node[] node;
    public static int size;
    // 최근에 제거된
    public static Stack<Node> stack;
    public static StringBuilder sb;
    
    public void restore(){
        // 나의 원래 prev가 삭제된 경우까지 고려해야함
        // 나의 원래 next가 삭제된 경우 고려
        Node recovery = stack.pop();
        // System.out.println(recovery.num+"복귀");
        
        if(recovery.prev!=null){
            while(recovery.prev.delete && recovery.prev.prev!=null){
                recovery.prev = recovery.prev.prev;
            }
            recovery.prev.next = recovery;
        }

        if(recovery.next!=null){
            while(recovery.next.delete && recovery.next.next!=null){
                recovery.next = recovery.next.next;
            }
            recovery.next.prev = recovery;
        }
        
     
        recovery.delete = false;
        size++;
        sb.setCharAt(recovery.num,'O');
    }
    public void remove(Node cnt){
        
        if(cnt.prev!=null){
            cnt.prev.next = cnt.next;        
        }
        if(cnt.next!=null){
            cnt.next.prev = cnt.prev;        
        }
        cnt.delete = true;
        size--;
        sb.setCharAt(cnt.num,'X');
    }
    public String solution(int n, int k, String[] cmd) {
        
        sb = new StringBuilder("O".repeat(n));
        
        stack = new Stack<>();
        node = new Node[n];
        size = n;
        node[0] = new Node(0,null);
        
        // 원형 링크드 리스트 만들기
        for(int i=1;i<n;i++){
            node[i] = new Node(i,node[i-1]);
            node[i-1].next = node[i];
        }
        // node[0].next = node[1];
        // node[0].prev = node[n-1];
        // node[n-1].next = node[0];

        Node cnt = node[k];
        
        int save = 0;
        try{
            for(int i=0;i<cmd.length;i++){
                save = i;
                String[] tmp = cmd[i].split(" ");

                if(tmp[0].equals("U")){
                    int moveDis = Integer.parseInt(tmp[1]);            

                    for(int j=0;j<moveDis;j++){
                        cnt = cnt.prev;
                    }                

                }
                else if(tmp[0].equals("D")){
                    int moveDis = Integer.parseInt(tmp[1]);            

                    for(int j=0;j<moveDis;j++){
                        cnt = cnt.next;
                    }

                }
                else if(tmp[0].equals("C")){                    
                    remove(cnt);
                    
                    stack.add(cnt);
                    if(cnt.next==null){
                        cnt = cnt.prev;
                    }
                    else{
                        cnt = cnt.next;                
                    }
                    
                    // 삭제된 행이 마지막행인 경우 바로 윗 행을 선택합니다.

                }
                else if(tmp[0].equals("Z")){        
                    restore();
                }
                // System.out.println(cnt.num);
            }
            
        } catch(Exception e){
            // System.out.println("실패");
            // System.out.println(save);
            // System.out.println(cnt.num);            
        }
        
        
        return sb.toString();

        // return answer;
    }
    
    class Node{
        Node prev;
        Node next;
        int num;
        boolean delete;
        
        Node(int num, Node prev){
            this.num=num;
            this.prev = prev;
            this.delete = false;
        }
        
    }
    

}