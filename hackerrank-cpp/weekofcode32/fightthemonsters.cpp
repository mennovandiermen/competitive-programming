#include <bits/stdc++.h>

using namespace std;

int getMaxMonsters(int shots, map<int, int> m){
    int kills = 0;
    for(map<int, int>::iterator it = m.begin(); it != m.end(); it++) {
        if(shots < it->first*m[it->first]) {
            kills += shots/it->first;
            return kills;
        }
        else {
            kills += m[it->first];
            shots -= it->first*m[it->first];
        }
    }
    return kills;
}

int main() {
    map<int, int> m;
    int n;
    int hit;
    int t;
    cin >> n >> hit >> t;
    for(int h_i = 0; h_i < n; h_i++){
        int h;
        cin >> h;
        m[ceil(h/double(hit))]++;
    }
    int result = getMaxMonsters(t, m);
    cout << result << endl;
    return 0;
}
