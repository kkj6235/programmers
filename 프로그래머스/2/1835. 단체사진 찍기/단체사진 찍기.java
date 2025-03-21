class Solution {
    
    public static String[] member = {"A", "C", "F", "J", "M","N","R","T"};
    public static boolean[] visited;
    public static int answer;
    
    public void dfs(String orders, String[] data){
        // 조합 다 만들기 아니야?
        if(orders.length()==8){
            if(check(orders,data)){
                answer++;
            }
            return ;
        }
        
        for(int i=0;i<member.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(orders+member[i], data);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String orders, String[] data){
        for(String s:data){
            
            int first = orders.indexOf(s.charAt(0));
            int second = orders.indexOf(s.charAt(2));
            char op = s.charAt(3);
            int length = Integer.parseInt(String.valueOf(s.charAt(4)));
            
            if(op=='='){
              if(!(Math.abs(first-second)==length+1)){
                  return false;
              }  
            }
            else if(op=='>'){
               if(!(Math.abs(first-second)>length+1)){
                  return false;
              } 
            }
            else if(op=='<'){
               if(!(Math.abs(first-second)<length+1)){
                  return false;
              } 
            }
            
        }
        return true;
        
    }
    
    public int solution(int n, String[] data) {
        
        visited = new boolean[8];
        answer = 0;
        
        dfs("", data);
        
    
        return answer;
    }
}