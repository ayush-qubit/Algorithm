def gcd(m,n):
    if m==0:
        return n
    elif n==0:
        return m
    else:
        return gcd(n,m%n)

def pourJug(toJugCap,fromJugCap,amt):
    toJug=0
    fromJug=fromJugCap
    step=1
    while (toJug!=amt) and (fromJug!=amt):
        temp=min(fromJug,toJugCap-toJug)
        toJug+=temp
        fromJug-=temp
        step+=1
        if toJug==amt or fromJug==amt:
            break
        if toJug==toJugCap:
            toJug=0
            step+=1
        if fromJug==0:
            fromJug=fromJugCap
            step+=1
    return step

def printSteps(n,m,d):
    if n<m:
        n,m=m,n
    if (d%gcd(m,n))!=0:
        print(-1)
        return

    noofsteps=min(pourJug(n,m,d),pourJug(m,n,d))
    print(noofsteps)

printSteps(5,3,4)