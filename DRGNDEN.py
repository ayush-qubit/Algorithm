class Node:
    def __init__(self,x,height,spices):
        self.x=x
        self.height=height
        self.spices=spices


def makeTreeRL(height,spices,n):
    












n,q=map(int,input().split())
height=list(map(int,input().split()))
spices=list(map(int,input().split()))
for _ in range(q):
    code,a,b=input().split()
    