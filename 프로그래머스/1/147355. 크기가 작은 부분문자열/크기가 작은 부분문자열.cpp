#include <string>
#include <vector>
#include<iostream>
using namespace std;

int solution(string t, string p) {
    int answer = 0;
    
    // auto nump=stoi(p);
    
    
    for(int i=0;i<=t.size()-p.size();i++){
        auto tmp = t.substr(i,p.size());
        if(stoll(tmp)<=stoll(p)){
            answer++;
        }
    }
    return answer;
}