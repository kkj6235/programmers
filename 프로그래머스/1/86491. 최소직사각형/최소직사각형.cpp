#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
using namespace std;

int solution(vector<vector<int>> sizes) {
    
    sort(sizes[0].begin(),sizes[0].end(),greater<int>());
    auto xmax=*sizes[0].begin();
    auto ymax=*(sizes[0].end()-1);

    for(int i=1;i<sizes.size();i++){
        sort(sizes[i].begin(),sizes[i].end(),greater<int>());
        if(*sizes[i].begin()>xmax){
            xmax=*sizes[i].begin();
        }
        if(*(sizes[i].end()-1)>ymax){
            ymax=*(sizes[i].end()-1);            
        }
    }
    
    cout<< xmax <<" "<<ymax<<endl;
    return xmax*ymax;
}