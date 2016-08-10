t=input()
for i in range(t):
    a,b=map(int, raw_input().split())
    prime = [True]*(b+1)
    i = 2
    while i*i <= b :
        if prime[i] :
            j = 2*i
            while j <= b :
                prime[j] = False
                j += i
        i += 1

    for i in range(a,b+1):
        if prime[i] :
            print i
