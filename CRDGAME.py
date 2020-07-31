for _ in range(int(input())):
    winC=0
    winM=0
    n=int(input())
    for _ in range(n):
        a,b=input().split()
        sum1=sum(list(map(int,a)))
        sum2=sum(list(map(int,b)))
        if sum1>sum2:
            winC+=1
        elif sum1<sum2:
            winM+=1
        else:
            winC+=1
            winM+1
    if winC>winM:
        print(0,winC,sep=' ')
    elif winC<winM:
        print(1,winM,sep=' ')
    else:
        print(2,winC,sep=' ')