from bisect import bisect_left
arr=[]
def add_element(val):
    pos=bisect_left(arr,val)
    arr.insert(pos,val)
    print(median(arr))

def remove_element(val):
    n=len(arr)
    if n==0:
        print('Wrong!')
        return
    try:
        arr.remove(val)
        print(median(arr))
    except ValueError:
        print('Wrong!')

def median(arr):
    n=len(arr)
    if n==0:
        return 'Wrong!'
    mid=int(n/2)
    if n%2==0:
        med=(arr[mid]+arr[mid-1])/2
        return med
    else:
        med=arr[mid]
        return med

n=int(input())
for _ in range(n):
    ch,val=input().split()
    if ch=='a':
        add_element(int(val))
    else:
        remove_element(int(val))