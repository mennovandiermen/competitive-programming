#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin >> n;
    int types[5];
    for(int i=0; i<5; i++) types[i] = 0;
    for(int types_i = 0; types_i < n; types_i++){
        int brd;
        cin >> brd;
        types[brd-1]++;
    }
    int max = 0;
    for(int i=1; i<5; i++) {
        if(types[i] > types[max]) max = i;
    }
    cout << max+1;
    return 0;
}