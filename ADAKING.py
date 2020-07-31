def solution(k):
    for i in range(0,8):
        for j in range(0,8):
            if i==0 and j==0:
                print('O',end='')
                k-=1
            else:
                if k>0:
                    print('.',end='')
                else:
                    print('X',end='')
                k-=1
        print()


q=int(input())
while q>0:
    k=int(input())
    solution(k)
    q-=1