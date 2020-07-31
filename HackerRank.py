def modified_array(arr,i,j,code):
    n=len(arr)
    if code==1:
        temp=arr[i-1:j]
        arr=arr[0:i-1]+arr[j:n]
        arr=temp+arr
    else:
        temp=arr[i-1:j]
        arr=arr[0:i-1]+arr[j:n]
        arr=arr+temp
    return arr

n,q=map(int,input().split())
arr=list(map(int,input().split()))
for _ in range(q):
    code,start,end=input().split()
    arr=modified_array(arr,int(start),int(end),int(code))
print(abs(arr[0]-arr[n-1]))
for ele in arr:
    print(ele,end=' ')