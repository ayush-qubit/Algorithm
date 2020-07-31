class Node:
    def __init__(self,data):
        self.data=data
        self.next=None

def insert(head,data):
    if head==None:
        return Node(data)
    else:
        temp=Node(data)
        temp.next=head
        head=temp
        return head


def printList(head):
    while head!=None:
        print(head.data,end=' ')
        head=head.next
    print()

head=None
input('ENter number: ')
head=insert(head,6)
head=insert(head,5)
head=insert(head,4)
head=insert(head,3)
head=insert(head,2)
head=insert(head,1)
printList(head)