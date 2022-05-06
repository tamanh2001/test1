n=int(input())
sdn=0
snv=n
flag=1

for i in range(2,n):
    if n%i==0:
       flag=0
       break
if flag==1:
   while n!=0:
      sdn=sdn*10+n%10
      n=n//10
   if sdn==snv:
      print(1)
   else:
      print(0)
else:
   print(0)