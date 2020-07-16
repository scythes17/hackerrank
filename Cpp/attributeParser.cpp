#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
#include <sstream>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n, q;   
    string s, assembledtags="";
    cin >> n >> q;
    cin.ignore();
    map <string, string> attributes;

    // first the HRML
    for (int i=0; i<n; i++) {
        getline(cin, s);
        stringstream ss(s);
        string word, tag, attribute, value;
        size_t index;
        while (getline(ss, word, ' ')) { //taking out words seperated by <space> from the stringstream
            if (word[0]=='<') { // if it is a tag
                if (word[1]=='/') { // ending tag
                    tag = word.substr(2);
                    tag = tag.substr(0, tag.length()-1);
                    index = assembledtags.find('.'+tag);
                    if (index != string::npos) {
                        assembledtags = assembledtags.substr(0,index);
                    } else {
                        assembledtags = "";
                    }
                } else { // starting tag
                    tag = word.substr(1);
                    // In case the tag contains no value <tag1> we need to remove ">"
                    if (word.find('>') != string::npos) {
                        tag = tag.substr(0, tag.length()-1);
                    }
                    if (assembledtags == "") { //no tags in assembledtags
                        assembledtags = tag;
                    } else {
                        assembledtags = assembledtags + '.' + tag; // creating subtags tag1.tag2
                    }
                }
            } else if (word[0] == '"') { // value
                index = word.find_last_of('"');
                value = word.substr(1, index-1);
                attributes[attribute] = value;
            } else if (word[0]!='=') { // attribute
                attribute = assembledtags + '~' + word; // adding attriubtes to subtags tag1.tag2~name 
            }
        }
    }

    for (int i =0; i<q; i++) {
        getline(cin, s);
        if (attributes.find(s) == attributes.end()) {
            cout << "Not Found!" << endl;
        }  else {
            cout << attributes[s] << endl;
        }
    }
    return 0;
}
