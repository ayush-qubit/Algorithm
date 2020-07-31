import sys
def solution(S,N,P):
    prefix=[0]*N
    S.sort(reverse=True)
    prefix[0]=S[0]
    for i in range(1,N):
        prefix[i]=prefix[i-1]+S[i]
    train=sys.maxsize
    i=0
    while i<N-P+1:
        a=S[i]*(P-1)
        b=prefix[i+P-1]-prefix[i]
        train=min(train,a-b)
        i+=1
    return train
if __name__ == "__main__":
    q=int(input())
    while q>0:
        N,P=map(int,input().split())
        S=list(map(int,input().split()))
        print('Case #',q,':',sep='',end=' ')
        print(solution(S,N,P))
        q-=1