class Solution {
    
    public static int answer;
    public void dfs(int[] numbers, int sum, int count, int target){
        
        if(count==numbers.length){
            // System.out.println("sum : "+sum);            
            if(sum==target){
                answer++;
            }
            return ;
        }
        
        dfs(numbers, sum+numbers[count], count+1, target);
        dfs(numbers, sum-numbers[count], count+1, target);
    }
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        try{
            dfs(numbers, 0, 0, target);            
        }
        catch(Exception e){
        }
        return answer;
    }
}