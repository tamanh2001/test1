a=int(input("nhap so:"))
b=int(input("nhap so:"))
for i in range(1,a+1):
    if (a%i==0) and (b%i==0):
        c=i
print(str(c))