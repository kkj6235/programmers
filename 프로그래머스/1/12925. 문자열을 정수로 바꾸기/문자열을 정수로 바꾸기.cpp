#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string s) {
    int answer = 0;
    if(s[0]=='-'){
        s.erase(s.begin());
        return (-1)*stoi(s);
    }
    return stoi(s);

}