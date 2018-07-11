#include <iostream>
#include <vector>
using namespace std;

void displayPathtoPrincess(int n, vector <string> grid){
    int r = n/2; int c = n/2;
    for (int i = 0; i < n; i++) {
        string s = grid[i];
        for (int j = 0; j < n; j++) {
            if(s[j] == 'p') {
                if(i < r) {
                    while(i < r) {
                        cout << "UP" << endl;
                        r--;
                    }
                } else if (i > r) {
                    while (i > r) {
                        cout << "DOWN" << endl;
                        r++;
                    }
                }
                if (j < c) {
                    while (j < c) {
                        cout << "LEFT" << endl;
                        c--;
                    }
                } else if (j > c) {
                    while (j > c) {
                        cout << "RIGHT" << endl;
                        c++;
                    }
                }
            }
        }
    }
}

int main(void) {

    int m;
    vector <string> grid;

    cin >> m;

    for(int i=0; i<m; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    displayPathtoPrincess(m,grid);

    return 0;
}
