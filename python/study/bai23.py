n=int(input("nhap so n:"))
if 99<n<999:
   A=n//100
   print(A)
if n>999:
   B=n//1000
   print(B)
if n<100:
   print("0")
