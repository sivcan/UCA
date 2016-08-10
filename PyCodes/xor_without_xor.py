def xorer(a,b):
    return (~a&b) | (a&~b)

print (xorer(3,5))
