#include <bits/stdc++.h>

using namespace std;

int main(){
    string tgt = "hackerrank";
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        int i = 0, j=0;
        string s;
        cin >> s;
        while(j<tgt.length()) {
            while(s[i] != tgt[j] && i < s.length()) i++;
            j++; i++;
            if(i>=s.length()) break;
        }
        if(j == tgt.length()) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
    return 0;
}
