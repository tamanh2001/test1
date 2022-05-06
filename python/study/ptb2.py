a=int(input("nhap he so thu 1:"))
b=int(input("nhap he so thu 2:"))
c=int(input("nhap he so thu 3:"))
delta=b*b-4*a*c
if delta<0:
   print("phuong trinh vo nghiem")
elif delta==0:
   print("phuong trinh co nghiem kep:",(-b)/(2*a))
else:
   print("nghiem thu nhat:",(-b-delta*0.5)/(2*a))
   print("nghiem thu hai:",(-b+delta*0.5)/(2*a))

