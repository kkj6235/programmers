class Solution {
    
    public long[] getY(int x){
        long[] result = new long[2];
        
        result[0] = (long)Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(x,2)));
        result[1] = (long)Math.floor(Math.sqrt(Math.pow(r2,2)-Math.pow(x,2)));
        
        // System.out.println(Math.sqrt(r1*r1-x*x)+" "+Math.sqrt(r2*r2-x*x));
        
        // System.out.println(result[0]+" "+result[1]);
        return result;
    }
    
    public int r1,r2;
    public long solution(int r1, int r2) {
        long answer = 0;
        this.r1=r1;
        this.r2=r2;
        
        for(int i=0;i<=r2;i++){
            
            long[] Y = getY(i);
  
            if(i==0){
                answer+=2*(Y[1]-Y[0]+1);
            }
            else{
                if(Y[1]==0){
                    answer+=2;
                }
                else if(Y[0]==0){
                    answer+=2;
                    Y[0] = Math.min(Y[1], Y[0]+1);
                    answer+=4*(Y[1]-Y[0]+1);
                }
                else{
                    answer+=4*(Y[1]-Y[0]+1);                                             
                }
 
            }
            
            // y축, x축 위에있는지 판단하기?
            // System.out.println(answer);
                       
        }
        
        
        return answer;
    }
}



/*
r1*r1 <= x*x + y*y <= r2*r2
*/