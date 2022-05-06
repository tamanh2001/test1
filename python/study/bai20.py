n=int(input("nhap so :"))
A=n%10
n=int(n/10)
B=n%10
n=int(n/10)
C=n%10
n=int(n/10)
print(max(A,B,C))