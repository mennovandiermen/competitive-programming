#include <bits/stdc++.h>

using namespace std;

void buildS(int * s, int size) {
    if (size>1024) return;
    for(int i=0; i<size; i++) {
        s[i+size] = !s[i];
    }
    buildS(s, size*2);
}

int main() {
    int * s = new int[1024];
    s[0] = 0;
    buildS(s, 1);
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        int x;
        cin >> x; 
        cout << s[x] << endl;
    }
    return 0;
}