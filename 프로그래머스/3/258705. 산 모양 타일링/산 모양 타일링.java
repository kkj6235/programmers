import java.io.*;
import java.util.*;

// tops[i]==1인 경우
/*

1. 위 삼각형과 
2. 왼쪽 삼각형과
3. 오른쪽 삼각형과
4. 아무와도 결합하지 않음


a[k] : 3번째인경우
b[k] : 3번째 아닌 경우


a[k] = a[k-1]+b[k-1];

b[k] = 2*a[k-1] + 3*b[k-1];
*/


// tops[i]==0
/*

a[k] = a[k-1]+b[k-1];
b[k] = a[k-1] + 2*b[k-1];

*/


class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[] a= new int[n+1];
        int[] b= new int[n+1];
        
        a[0]=0;
        b[0]=1;
        for(int i=1;i<=n;i++){
            if(tops[i-1]==1){
                a[i]= (a[i-1]+b[i-1])%10007;
                b[i] = (2*a[i-1]+3*b[i-1])%10007;
            }
            else{
                a[i]=(a[i-1]+b[i-1])%10007;
                b[i] = (a[i-1]+2*b[i-1])%10007;
            }
        }
        
        return (a[n]+b[n])%10007;
    }
}