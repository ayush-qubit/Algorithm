def solution(arr,n):
    ans=0
    suffix=[0]*(n+1)
    for i in reversed(range(1,n+1)):
        if i==n:
            suffix[i]=arr[i]
        else:
            suffix[i]=arr[i]*int(pow(2,n-i))+suffix[i+1]
    for k in range(0,n):
        if k==0:
            a=arr[k]*suffix[k+1]
        else:
            a=arr[k]*int(pow(2,k-1))*suffix[k+1]
        ans+=a
    m=int(pow(10,9))+7
    print((2*ans)%m)

for _ in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    solution(arr,n)