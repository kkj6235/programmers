#include <string>
#include <vector>
#include<iostream>
#include<cmath>
#include<cctype>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    auto x=sqrt(n);
    if((x-(long long)x)==0){
        
        return (x+1)*(x+1);   
    }
    return -1;
}