n=int(input("nhap so:"))
number=[]
while n>0:
    T=n%10
    n=int(n/10)
number.append(n%10)
print(max(number))