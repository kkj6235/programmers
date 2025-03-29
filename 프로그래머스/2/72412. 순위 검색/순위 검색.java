import java.io.*;
import java.util.*;

class Solution {
    
    public static Map<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        answer = new int[query.length];
        map = new HashMap<>();
        
        for(String i : info){
            makeMap("",i.split(" "),0);    
        }
        
        for(List<Integer> list : map.values()){
            Collections.sort(list, Collections.reverseOrder());
        }
        
        for(int i=0;i<query.length;i++){
            query[i] = query[i].replaceAll(" and ","");
            String[] list = query[i].split(" ");
            answer[i]= map.containsKey(list[0]) ? binarySearch(map.get(list[0]), Integer.parseInt(list[1])) : 0;
        }
        
        return answer;
    }
    
    public int binarySearch(List<Integer> values, int score){
        
        int start = 0;
        int end = values.size();
        int m=0;
        
        if(values.size()==1){
            if(values.get(0)>=score){
                return 1;
            }
            return 0;
        }
        
        while(start<end){
            m = (start+ end) / 2;
            if(score > values.get(m)){
                end = m;
            }
            else {
                start = m+1;
            }
        }
        
        return end;
    }
    public void makeMap(String key, String[] words, int cnt){
        if(cnt==4){
            int value = Integer.parseInt(words[words.length-1]);
            
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>(Arrays.asList(value)));
            }            
            else{
                map.get(key).add(value);
            }
            return ;
        }
        makeMap(key+"-", words, cnt+1);
        makeMap(key+words[cnt], words, cnt+1);                
    }
}