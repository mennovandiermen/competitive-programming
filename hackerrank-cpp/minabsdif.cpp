#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin >> n;
    int *a = new int[n];
    for(int a_i = 0; a_i < n; a_i++){
       cin >> a[a_i];
    }
    sort(a, a+n);
    int dif = abs(a[0]-a[1]);
    for(int i=1; i<n-1; i++) {
        int cur = abs(a[i]-a[i+1]);
        if(cur < dif) dif = cur;
    }
    cout << dif;
    return 0;
}
