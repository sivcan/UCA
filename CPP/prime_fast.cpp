// #include <iostream>
// #include <cstring>
// // Sieve of Eratosthenes
// using namespace std;
// int main() {
//     long int a, n;
//     cout<<"\nSeive Of Eratosthenes."<<endl;
//     cout<<"\nEnter range (a,b): ";
//     cin>>a>>n;
//     //Allocating a boolean array of size n+1
//     bool prime[n+1];
//     //Setting all the array to 1.
//     memset(prime,true,sizeof(prime));
//     //Traversing array to mark the Sieve.
//     for(int i = 2; i <= n; i++) {
//         if(prime[i]) {
//             for(int j = 2*i; j <= n; j += i) {
//                 prime[j] = false;
//             }
//         }
//     }
//     //Perfect! Printing the prime numbers.
//     for(int i = a; i <= n; i++) {
//         if(prime[i]) {
//             cout<<i<<" ";
//         }
//     }
//     cout<<endl;
//
//     return 0;
// }

#include <iostream>
#include <cstring>
#include <vector>
#include <cmath>
//Segmented Sieve - Better Space Complexity as compared to Sieve of Eratosthenes (When array's are large enough in size).
using namespace std;

void simpleSieve(int limit,  vector<int> &res)
{
    bool prime[limit+1];
    memset(prime,true,sizeof(prime));

    for(int i = 2; i*i <= limit; i++) {
        if(prime[i]) {
            for(int j = 2*i; j <= limit; j += i) {
                prime[j] = false;
            }
        }
    }

    for(int i = 2; i <= limit; i++) {
        if(prime[i]) {
            res.push_back(i);
        }
    }
}

void segmentedSieve(int a, int b) {
    int limit = floor(sqrt(b))+1;
    vector <int> prime;
    simpleSieve(limit, prime); //Marks the numbers upto sqrt.

    int low = limit;
    int high = 2 * limit;

    while(low < b) {
        bool mark[limit+1];
        memset(mark, true, sizeof(mark));

        for (int i = 0; i < prime.size(); i++) {
            int loLim = floor(low/prime[i]) * prime[i];
            if(loLim < low) {
                loLim += prime[i];
            }

            for (int j = loLim; j < high; j += prime[i]) {
                mark[j-low] = false;
            }
        }

        for(int i = low; i < high; i++) {
            if (mark[i-low]) {
                cout<<i<<endl;
            }
        }

        low = low + limit;
        high = high + limit;
        if(high >= b) {
            high = b;
        }
    }

}




int main() {
    int a, b, t;
   	cin>>t;
   	while(t--)  {
    cin>>a>>b;
    segmentedSieve(a,b);
   	}
    return 0;
}
