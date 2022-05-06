n=int(input())
if n<2:
    print(0)
else:
    for i in range(2,n):
        if n%i==0:
            print(0)
        else:
            while n!=0:
                du=n%10
                dao=du*10+du
                n=n//10
            if n==dao:
                print(1)