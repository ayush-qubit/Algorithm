import sys
def LEFT(pos):
    return 2*pos+1
def RIGHT(pos):
    return 2*pos+2
def make_tree(arr,segtree,low,high,pos):
    if low==high:
        segtree[pos]=arr[low]
        return segtree
    else:
        mid = int((low + high) / 2)
        segtree = make_tree(arr, segtree, low, mid, LEFT(pos))
        segtree = make_tree(arr, segtree, mid + 1, high, RIGHT(pos))
        segtree[pos] = min(segtree[LEFT(pos)], segtree[RIGHT(pos)])
        return segtree

def find_query(segtree,qlow,qhigh,low,high,pos):
    if qlow<=low and high<=qhigh:
        return segtree[pos]
    elif (low<qlow and high<qlow) or (low>qhigh and high>qhigh):
        return sys.maxsize
    else:
        mid=int((low+high)/2)
        L=find_query(segtree,qlow,qhigh,low,mid,LEFT(pos))
        R=find_query(segtree,qlow,qhigh,mid+1,high,RIGHT(pos))
        return min(L,R)
def find_length(n):
    power=0
    l=int(pow(2,power))
    while l<n:
        power+=1
        l=int(pow(2,power))
    return 2*l-1

arr=[-1,3,4,0,2,1]
segtree=[0]*find_length(len(arr))
segtree=make_tree(arr,segtree,0,5,0)
print(segtree)
print('Elements are: ',arr,sep=' ')
print('Minumum of elements from ',1,5,':',find_query(segtree,1,5,0,5,0),sep=' ')