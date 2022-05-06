def giaithua(a):
       h=1
       for i in range(1,a+1):
          h=h*i
       return h
n=int(input("nhap so:"))
x=0
for k in range(1,n+1):
   x=x+(giaithua(k)/((k*(k+1)/2)))
print(x)
