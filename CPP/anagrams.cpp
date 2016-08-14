#include <iostream>
#include <vector>

using namespace std;

//My Code's Time Complexity : O(n)
//Used Hashing
//Space Complexity : O(n)

int main() {
    char a[] = {"abc"};
    char b[] = {"bac"};
    vector <int> x(3);
    x.assign(3,0);

    for(int i = 0; a[i] != '\0'; i++) {
        x[a[i] - 'a']++;
    }

    bool flag = false;
    for(int i = 0; b[i] !='\0'; i++) {
        if(x[b[i] - 'a'] == 0) {
            flag = true;
            break;
        }
        else {
            x[b[i]-'a']++;
        }
    }

    if(flag) {
        cout<<"\nStrings are not anagrams.";
    }
    else {
        flag = false;
        for(int i = 0; a[i]!='\0'; i++) {
            if(x[i]%2 != 0) {
                flag = true;
            }
        }
        if(flag)
            cout<<"\nStrings are not anagrams.";
        else {
            cout<<"\nStrings are anagrams!";
        }
    }
    cout<<endl;

    return 0;
}
