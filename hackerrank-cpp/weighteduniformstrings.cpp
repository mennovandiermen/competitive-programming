#include <iostream>

using namespace std;


int main(){
    string s;
    cin >> s;
    int n;
    cin >> n;
    int al[26]; 
    for(int ia=0; ia<26; ia++) al[ia] = 0;
    for(int i=0; i<s.length(); i++) {
        int idx = (int) (s[i] - 'a');
        int ct = 1;
        while(s[i] == s[i+1]) {
            ct++; i++;
        }
        if(al[idx] < ct) al[idx] = ct;
    }
    for(int a0 = 0; a0 < n; a0++) {
        int x;
        cin >> x;
        bool in = false;
        for(int idx=0; idx<26; idx++) {
            if((al[idx]*(idx+1)) >= x && (x % (idx+1)) == 0) {
                in = true;
                break;
            }
        }
        string out = in ? "Yes" : "No";
        cout << out << endl;
    }
    return 0;
}
