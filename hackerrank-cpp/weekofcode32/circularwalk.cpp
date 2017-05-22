#include <bits/stdc++.h>

using namespace std;

void bfs(int n, int *r, int *c, int s, int t) {
    queue<int> q;
    q.push(s); c[s] = 0;
    while (!q.empty()) {
        int nd = q.front(); q.pop();
        for(int i = nd - r[nd]; i <= nd + r[nd]; i++) {
            int t_i = i;
            if(i < 0) t_i = n + i;
            else if(i > n-1) t_i = i-n;
            if(t_i == nd) continue;
            if(c[t_i] < 0) {
                c[t_i] = c[nd]+1;
                if(t_i == t) return;
                q.push(t_i);
            }
        }
    }
}

int circularWalk(int n, int s, int t, int *r,  int *c, int g, int seed, int p) {
    if (s == t) return 0;
    bfs(n, r, c, s, t);
    return c[t];
}

int main() {
    int n, s, t, g, p, r_0, seed;
    cin >> n >> s >> t >> r_0 >> g >> seed >> p;
    int *r = new int[n]; int *c = new int[n]; r[0] = r_0; c[0] = -1;
    for(int i=1; i<n; i++) { r[i] = (r[i-1] * g + seed) % p; c[i] = -1; }
    int result = circularWalk(n, s, t, r, c, g, seed, p);
    cout << result << endl;
    delete[] r; delete[] c;
    return 0;
}