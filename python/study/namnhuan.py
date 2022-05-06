n=int(input("nhap nam:"))
if n%4==0 and (n%400==0 or n%100!=0):
   print("day la nam nhuan")
else:
   print("day khong phai nam nhuan")