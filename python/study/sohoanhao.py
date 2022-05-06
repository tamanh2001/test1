n=int(input("nhap so:"))
t=0
for i in range(1,n+1):
    if n%i==0:
       t=t+i
       if t==n:
          print("1")
          break
    else:
        print("0")
        break

