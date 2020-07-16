#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n, q;
    cin >> n >> q;
    vector< vector<int> > vec(n); 
    for( int i=0; i<n; i++){
        int k;
        cin >> k;

        vec[i].resize(k);
        for( int j =0; j<k; j++){
            int ele;
            cin >> ele;
            vec[i][j] = ele; 
        }
    }

    for( int x=0; x<q; x++){
        int i, j;
        cin >> i >> j;
        cout << vec[i][j] << endl;
    }
    return 0;
}
