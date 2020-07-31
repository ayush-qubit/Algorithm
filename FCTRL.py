powerof5=[0]*14
powerof5[0]=1
for i in range(1,14):
    powerof5[i]=powerof5[i-1]*5
def calculate(n):
    count=0
    while n>0:
        count+=int(n/5)
        n=int(n/5)
    return count

for _ in range(int(input())):
    n=int(input())
    print(calculate(n))