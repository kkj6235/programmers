class Solution {
    
    public void dfs(int x,int y, boolean row){
        
        if(board[x].charAt(y)=='.'){
            return ;
        }
        
        char tmp = board[x].charAt(y);
        if(row){
            for(int i=1;i<3;i++){
                if(tmp!=board[x].charAt(y+i)){
                    return ;
                }
            }
            
            
        }
        else{
            for(int i=1;i<3;i++){
                if(tmp!=board[x+i].charAt(y)){
                    return ;
                }
            }
        }
        
        if(tmp=='O'){
            oWin++;
        }
        else{
            xWin++;
        }

    }
    
    public void diagonal(int x, int y, boolean left){
        
        if(board[x].charAt(y)=='.'){
            return ;
        }
        char tmp = board[x].charAt(y);
        
        if(left){
            for(int i=1;i<3;i++){
                if(tmp!=board[x+i].charAt(y+i)){
                    return ;
                }
            }
        }
        else{
            for(int i=1;i<3;i++){
                if(tmp!=board[x+i].charAt(y-i)){
                    return ;
                }
            }
            
        }
        
        
        if(tmp=='O'){
            oWin++;
        }
        else{
            xWin++;
        }
        
    }
    
    int oWin, xWin;
    String[] board;
    public int solution(String[] board) {
        int answer = 1;
        
        int oCount=0;
        int xCount=0;
        oWin = 0;
        xWin = 0;
        this.board=board;
        // 갯수 check
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O'){
                    oCount++;
                }
                else if(board[i].charAt(j)=='X'){
                    xCount++;
                }
                
                if(i==0){
                    dfs(0,j,false);
                }
            }
            
            dfs(i,0, true);
        }
        
      
        diagonal(0,0, true);
        diagonal(0,2, false);
        
       if(xCount>oCount || oCount- xCount>1){
            return 0;
        }
        

        // o가 이긴 상황
        if(oWin!=0 && xCount>=oCount){
            return 0;
        }
        
        
        // x가 이긴 상황
        if(xWin!=0 && oCount>xCount){
            return 0;
        }
        
        
        return answer;
    }
}