import sys
def mid(low,high):
    if low==high+1:
        high=low
    return (low+high)/2

def avg(ele1,ele2):
    return (ele1+ele2)/2

def FindMedian(arr1,arr2):
    if len(arr1)>len(arr2):
        return FindMedian(arr2,arr1)
    n=len(arr1)
    m=len(arr2)
    total=int((n+m+1)/2)
    found=False
    low=0
    high=n-1
    while found!=True:
        middle=int(mid(low,high))
        parx=middle
        pary=total-parx
        leftmaxx=-sys.maxsize if parx-1<0 else arr1[parx-1]
        leftmaxy=-sys.maxsize if pary-1<0 else arr2[pary-1]
        rightminx=sys.maxsize if parx>n-1 else arr1[parx]
        rightminy=sys.maxsize if pary>m-1 else arr2[pary]
        if leftmaxx<=rightminy and leftmaxy<=rightminx:
            found=True
            break
        elif leftmaxx>rightminy:
            high=parx
        else:
            low=parx+1
    if ((n+m)%2)==0:
        return avg(max(leftmaxx,leftmaxy),min(rightminx,rightminy))
    else:
        return max(leftmaxx,leftmaxy)

arr2=[23,26,31,35]
arr1=[3,5,7,9,11,40]
print(FindMedian(arr1,arr2))