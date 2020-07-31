def word_break(dict,word):
    n=len(word)
    dp=[[None]*(n) for _ in range(n)]
    for l in range(n):
        i=0
        j=l
        while i<n-l:
            w=word[i:j+1]
            if w in dict:
                dp[i][j]=True
            else:
                q=False
                for k in range(i,j):
                    q=q or (dp[i][k] and dp[k+1][j])
                dp[i][j]=q
            i+=1
            j+=1
    return dp[0][n-1]

n=int(input('Enter number of words in Dictionary: '))
dict=[]
for _ in range(n):
    dict.append(input())
word=input('Enter Word: ')
print(word_break(dict,word))