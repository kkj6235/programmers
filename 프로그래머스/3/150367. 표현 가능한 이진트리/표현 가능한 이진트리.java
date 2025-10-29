import java.io.*;
import java.util.*;


class Solution {
    
    public boolean isZeroTree(String tree){
        
        if(tree.length()==0){
            return true;
        }
        
        int root= tree.length()/2;
        
        if(tree.charAt(root)=='1'){
            return false;
        }
        
        return isZeroTree(tree.substring(0,root))&&isZeroTree(tree.substring(root+1));
    }
    
    public boolean isBinaryTree(String tree){
        
        if(tree.length()==0){
            return true;
        }
        
        int n = tree.length();
        int root= n/2;
        
        // 0이면 너네 둘도 다 0이여야함
        if(tree.charAt(root)=='0'){
            return isZeroTree(tree.substring(0,root))&& isZeroTree(tree.substring(root+1));
        }
        
        return isBinaryTree(tree.substring(0,root))&&isBinaryTree(tree.substring(root+1));
    }
    
    /*
    1
    2~3
    4~7 
    8~15
    
    */
    public String getFullBinary(String tree){
        
        int depth = Long.toBinaryString(tree.length()).length();
        
        StringBuilder sb= new StringBuilder();
        
        
        // 2**depth-1과 tree.length() 차이 만큼 넣기!!
        
        int tmp = (int)Math.pow(2,depth)-1-tree.length();
        
        for(int i=0;i<tmp;i++){
            sb.append(0);
        }
        
        sb.append(tree);
        return sb.toString();
        
    }
    public int[] solution(long[] numbers) {
        
        int[] answer = new int[numbers.length];
        
        int idx=0;
        for(long number: numbers){
            String st = Long.toBinaryString(number);
            st = getFullBinary(st);
            if(isBinaryTree(st)){
                answer[idx]=1;
            }
            
            
            idx++;
        }
        return answer;
    }
}