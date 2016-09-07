#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
int main()
{
    vector <string> s1;
    string temp;
    int n;
    cout<<"\nEnter the number of strings you wish to enter : ";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        cin>>temp;
        s1.push_back(temp);
    }

    for(int i = 0; i < n; i++)
    {
        cout<<s1[i]<<" ";
    }
}
