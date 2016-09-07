#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

int main()
{
    vector <string> s1, s2;
    string temp;
    int n;
    cout<<"\nEnter the number of strings you wish to enter : ";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        cin>>temp;
        s1.push_back(i,temp);
    }
    s2.assign(s1.begin(), s1.end());

    for(int i = 0; i < n; i++)
    {
        sort(s1[i].begin(),s1[i].end());
    }

    for(int i = 0; i < n; i++)
    {
        sort(s1.begin(),s1.end());
    }


    for(int i = 0; i < n; i++)
    {
        cout<<s1[i]<<" ";
    }
    cout<<endl;
    for(int i = 0; i < n; i++)
    {
        cout<<s2[i]<<" ";
    }
    return 0;
}
