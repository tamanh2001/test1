n=int(input("nhap n:"))
def Tong(n):
    t=0
    for i in range(1,n+1):
      if i%3==0:
        t=t+i
    return t
print(Tong(n))