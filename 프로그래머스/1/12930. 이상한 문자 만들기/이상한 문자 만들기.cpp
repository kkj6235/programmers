#include <string>
#include <vector>
#include<iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    int count=0;
    for(int i=0;i<s.size();i++){
        if(s[i]==' '){
            count=0;
            continue;
        }
        if(count%2==0){
            // 대문자
            s[i]=toupper(s[i]);
        }
        else{
            // 소문자
            s[i]=tolower(s[i]);         
        }
        count++;
    }
    return s;
}