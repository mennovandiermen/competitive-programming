#include <iostream>
#include <vector>
using namespace std;
void nextMove(int n, int r, int c, vector <string> grid){
    for (int i = 0; i < grid.size(); i++) {
        string s = grid[i];
        for(int j = 0; j < n; j++) {
            if(s[j] == 'p') {
                if (i < r) cout << "UP";
                else if (i > r) cout << "DOWN";
                else if (j < c) cout << "LEFT";
                else cout << "RIGHT";
            }
        }
    }
}

int main(void) {

    int n, r, c;
    vector <string> grid;

    cin >> n;
    cin >> r;
    cin >> c;

    for(int i=0; i<n; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    nextMove(n, r, c, grid);
    return 0;
}