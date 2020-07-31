import sys

def LEFT(pos):
    return 2*pos+1

def RIGHT(pos):
    return 2*pos+2

def find_length(n):
    power=0
    l=int(pow(2,power))
    while l<n:
        power+=1
        l=int(pow(2,power))
    return 2*l-1

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

def update_segment_tree(segtree,lazytree,qlow,qhigh,low,high,delta,pos):
    if qlow>qhigh:
        return segtree,lazytree

    if lazytree[pos]!=0:
        segtree[pos]+=lazytree[pos]
        if low!=high:
            lazytree[LEFT(pos)]+=lazytree[pos]
            lazytree[RIGHT(pos)]+=lazytree[pos]
        lazytree[pos]=0

    if qhigh<low or qhigh>high:
        return segtree,lazytree

    if qlow<=low and high<=qhigh:
        segtree[pos]+=delta
        if low!=high:
            lazytree[LEFT(pos)]+=delta
            lazytree[RIGHT(pos)]+=delta
        return segtree,lazytree

    mid=int((low+high)/2)
    segtree,lazytree=update_segment_tree(segtree,lazytree,qlow,qhigh,low,mid,delta,LEFT(pos))
    segtree,lazytree=update_segment_tree(segtree,lazytree,qlow,qhigh,mid+1,high,delta,RIGHT(pos))
    segtree[pos]=min(segtree[LEFT(pos)],segtree[RIGHT(pos)])
    return segtree,lazytree

def find_query(segtree,lazytree,qlow,qhigh,low,high,pos):
    if qlow>qhigh:
        return sys.maxsize,segtree,lazytree

    if lazytree[pos]!=0:
        segtree[pos]+=lazytree[pos]
        if low!=high:
            lazytree[LEFT(pos)]+=lazytree[pos]
            lazytree[RIGHT(pos)]+=lazytree[pos]
        lazytree[pos]=0

    if qhigh<low or high<qlow:
        return sys.maxsize,segtree,lazytree

    if qlow<=low and high<=qhigh:
        return segtree[pos],segtree,lazytree

    mid=int((low+high)/2)
    l,segtree,lazytree=find_query(segtree,lazytree,qlow,qhigh,low,mid,LEFT(pos))
    r,segtree,lazytree=find_query(segtree,lazytree,qlow,qhigh,mid+1,high,RIGHT(pos))
    return min(l,r),segtree,lazytree

arr=[-1,2,4,1,7,1,3,2]
n=len(arr)
segtree=[0]*find_length(n)
lazytree=[0]*find_length(n)
segtree=make_tree(arr,segtree,0,n-1,0)
queries=[(0,3,3),(0,3,1),(0,0,2)]
queriesmin=[(3,5)]

for q in queries:
    segtree,lazytree=update_segment_tree(segtree,lazytree,q[0],q[1],0,n-1,q[2],0)
    print(segtree,lazytree,sep=' ')

for q in queriesmin:
    m,segtree,lazytree=find_query(segtree,lazytree,q[0],q[1],0,n-1,0)
    print(m,segtree,lazytree,sep=' ')
