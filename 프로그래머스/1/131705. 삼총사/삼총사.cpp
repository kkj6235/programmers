#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
using namespace std;

int solution(vector<int> number) {
    int answer = 0;
    sort(number.begin(),number.end());
    vector<int> temp;
    for(int i=0;i<number.size();i++){
        if(i<3){
            temp.push_back(1);
        }
        else{
            temp.push_back(0);
        }
    }
    do{
        int sum=0;
        for(int i=0;i<number.size();i++){
            if(temp[i]==1){
                sum+=number[i];
            }
        }
        if(sum==0){
            answer++;
        }
    }while(prev_permutation(temp.begin(),temp.end()));
    return answer;
}