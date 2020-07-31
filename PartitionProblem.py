def isSubset(arr,sum):
    n=len(arr)
    dp=[[False]*(sum+1) for _ in range(n+1)]
    dp[0][0]=True
    for i in range(1,sum+1):
        dp[0][i]=False
    for i in range(1,n+1):
        dp[i][0]=True
    for i in range(1,n+1):
        for j in range(1,sum+1):
            if i>j:
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=dp[i-1][j] or dp[i-1][j-i]
    return dp[n][sum]

def solution(arr):
    n=len(arr)
    sum1=sum(arr)
    if sum1%2==1:
        return False
    else:
        return isSubset(arr,int(sum1/2))

arr=list(map(int,input('Enter elements of subset: ').split()))
print(solution(arr))