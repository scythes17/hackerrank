#include <sstream>
#include <vector>
#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

vector<int> parseInts(string str) {
	// Complete this function
    vector<int> vec;
    stringstream s(str);
    string ele;
    int number =0;
    while (getline(s, ele, ',')) {
        stringstream(ele) >> number;
        vec.push_back(number);
    }
    return vec;
}

int main() {
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);
    for(int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }
    
    return 0;
}
