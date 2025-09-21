#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n) {

    int answer = 0;
    if(n<=0){
        return 0;
    }
 
    answer+=1;        
    
    for(int i=2;i<=n;i++){
        if(n%i==0){
            answer+=i;
        }
    }

    return answer;
}