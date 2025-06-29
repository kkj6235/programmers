#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    for(int i=0;i<s.size();i++){
        if(s[i]==' '){
            continue;
        }
        auto tmp =s[i]+n;
    
        if(tmp>'z'){
            s[i]='a'+(s[i]+n-'z'-1);
        }
        else if(tmp>'a'){
            if(s[i]<='Z'){
                s[i]='A'+(s[i]+n-'Z'-1);    
            }
            else{
                s[i]=s[i]+n;                
            }
        }
        else if(tmp>'Z'){
            s[i]='A'+(s[i]+n-'Z'-1);
        }
        else{
            s[i]=s[i]+n;
        }

    }
    return s;
}