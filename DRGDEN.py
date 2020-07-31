from collections import deque
class Node:
    def __init__(self,data,left,right):
        self.data=data
        self.left=left
        self.right=right

def maketreeLR(den,low,high):
    stack=deque()
    i=high
    while i>=low:
        if len(stack)==0:
            stack.append(den[i])
        else:
            








den=[3,1,4,1,5]
spices=[3,4,2,1,77]
LeftRight=maketreeLR(den,0,len(den)-1)