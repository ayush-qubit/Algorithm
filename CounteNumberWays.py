def count_ways(n):
    dp=[0]*(n+1)
    dp[0]=1
    for i in range(2,n+1):
        dp[i]+=dp[i-2]
    for i in range(5,n+1):
        dp[i]+=dp[i-5]
    for i in range(10,n+1):
        dp[i]+=dp[i-10]
    return dp[n]

n=int(input('Enter Score: '))
print('Number of ways with score 2,5 and 10 is: ',end=' ')
print(count_ways(n))