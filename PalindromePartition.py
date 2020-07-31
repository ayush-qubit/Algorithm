import sys
def isPalindrome(str):
    if str==str[::-1]:
        return True
    else:
        return False


def pal_part(str):
    n=len(str)
    dp=[[0]*(n) for _ in range(n)]
    for l in range(n):
        i=0
        j=l
        while i<n-l:
            if isPalindrome(str[i:j+1]):
                dp[i][j]=0
            else:
                q=sys.maxsize
                for k in range(i,j):
                    q=min(q,dp[i][k]+dp[k+1][j])
                dp[i][j]=q+1
            i+=1
            j+=1
    return dp[0][n-1]

str=input('Enter String: ')
print(pal_part(str))