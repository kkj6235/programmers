import java.io.*;
import java.util.*;

class Solution{

    
    public int solution(int [][]board)
    {
        
        int answer = 0;
        // int[][] sum = new int[board.length][board[0].length];
        
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(i==0 || j==0){
                    if(board[i][j]==1){
                        answer = Math.max(answer, 1);
                    }
                    continue;
                }
                else{
                    if(board[i][j]!=0){
                        int tmp = board[i][j-1];
                        // tmp = Math.min(tmp, board[i][j-1]);
                        tmp = Math.min(tmp, board[i-1][j]);
                        tmp = Math.min(tmp, board[i-1][j-1]);
                        board[i][j] = tmp+1;
                        answer = Math.max(answer, board[i][j]);
                    }

                }
            }
        }
        
        
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board[0].length;j++){
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return answer*answer;
    }
}