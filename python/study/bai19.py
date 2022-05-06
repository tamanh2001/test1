n=int(input("nhap so:"))
A=[]
for i in range(1,n+1):
   if n%i==0:
      A.append(i)
print(len(A))     