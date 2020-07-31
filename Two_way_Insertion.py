def sort_insertion(arr):
    n=len(arr)
    arr1=[0]*n
    mid=int(n/2)
    first=last=mid
    arr1[mid]=arr[0]
    for i in range(1,n):
        if arr[i]<arr1[mid]:
            if first>0:
                l=first
                while l<=mid and arr1[l]<arr[i]:
                    arr1[l-1]=arr1[l]
                    l+=1
                arr1[l-1]=arr[i]
                first-=1
            else:
                l=last
                while l>=first and arr1[l]>arr[i]:
                    arr1[l+1]=arr1[l]
                    l-=1
                arr1[l+1]=arr[i]
                last+=1
        else:
            if last<n-1:
                l=last
                while l>=mid and arr1[l]>arr[i]:
                    arr1[l+1]=arr1[l]
                    l-=1
                arr1[l+1]=arr[i]
                last+=1
            else:
                l=first
                while l<=last and arr1[l]<arr[i]:
                    arr1[l-1]=arr1[l]
                    l+=1
                arr1[l-1]=arr[i]
                first-=1
    return arr1

arr=[]
arr=list(map(int,input('Enter array of Integer: ').split()))
arr=sort_insertion(arr)
print(arr)