import java.io.*;
import java.util.*;

class Solution {
    
    public static List<List<Integer>> visited;
    public static int row,column, answer;
    public static List<List<Integer>> list;
    
    public void combination(List<Integer> subList, int idx){
               
        subList.add(idx);
        list.add(subList);
        
        for(int i=idx+1;i<column;i++){
            combination(new ArrayList<>(subList),i);
        }
    }
    
    public void search(List<Integer> subList, String[][] relation){
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<row;i++){
            String tmp="";
            for(int j=0;j<subList.size();j++){
               tmp += relation[i][subList.get(j)];
            }
            if(map.containsKey(tmp)){
                return ;
            }
            else{
                // System.out.println(tmp);
                map.put(tmp, i);
            }
        }
        
        answer++;
        visited.add(new ArrayList<>(subList));
    }
    public boolean check(List<Integer> subList){
        
        
        for(int i=0;i<visited.size();i++){
            if(subList.containsAll(visited.get(i))){
                return false;
            }
        }
        
        return true;
        
    }
    public int solution(String[][] relation) {
        answer = 0;

        row = relation.length;
        column = relation[0].length;
        visited= new ArrayList<>();
        list = new ArrayList<>();
        
        
        for(int i=0;i<column;i++){
            combination(new ArrayList<>(), i);            
        }
        
        
        list.sort((a, b)-> {
            
            if(a.size() != b.size()){
                return Integer.compare(a.size(),b.size());
            }
            return 0;
        });
        
        
        for(int i=0;i<list.size();i++){
            
            if(check(list.get(i))){
                search(list.get(i), relation);                
            }
            
        }

        return answer;
    }
}