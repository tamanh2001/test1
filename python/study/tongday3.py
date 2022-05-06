n=int(input("nhap so:"))
x=0
for i in range(1,n+1):
    x=x+(1/(i*(i+1)/2))
print(x)