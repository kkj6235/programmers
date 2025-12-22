import java.io.*;
import java.util.*;

class Solution {
    
    public List<Integer> solution(String[] genres, int[] plays) {
        
        // 장르별 총합
        Map<String, Integer> sum = new HashMap<>();
        
        // 장르별 저장 id -> 우선순위 큐
        Map<String, PriorityQueue<Music>> musicMap = new HashMap<>();
        
        int n = genres.length;
        
        for(int i=0;i<n;i++){
            
            String genre = genres[i];
            int play = plays[i];
            
            
            if(sum.containsKey(genre)){
                int tmp = sum.get(genre);
                sum.replace(genre, tmp+play);
                
                PriorityQueue<Music> pq = musicMap.get(genre);
                pq.add(new Music(i,play));
            }
            else{
                sum.put(genre, play);
                PriorityQueue<Music> pq = new PriorityQueue<>();
                pq.add(new Music(i,play));
                musicMap.put(genre, pq);
            }
        }
        
        
        // 음악별 정렬 완료
        // 장르별 정렬 시작
        List<String> sortedGenres = new ArrayList<>(sum.keySet());
        sortedGenres.sort((a,b)-> Integer.compare(sum.get(b), sum.get(a)));
        
        List<Integer> answer = new ArrayList<>();
        
        // 정렬 완료 후 꺼내어 answer에 저장..
        for(String genre : sortedGenres){
           
            if(musicMap.containsKey(genre)){
                PriorityQueue<Music> pq = musicMap.get(genre);
                
                for(int i=0;i<2;i++){
                    if(!pq.isEmpty()){
                        answer.add(pq.poll().id);                
                    }
                }
                
            }
            
        }        
        
        return answer;
    }
    
    class Music implements Comparable<Music>{
        
        int id;
        int sum;
        
        Music(int id, int sum){
            this.id=id;
            this.sum=sum;
        }
        
        @Override
        public int compareTo(Music music){
            return Integer.compare(music.sum, this.sum);
        }
    }
}