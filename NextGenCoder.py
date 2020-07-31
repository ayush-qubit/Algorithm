import string
def CountCharacter(str1,str2):
    i=j=0
    n=len(str1)
    m=len(str2)
    count=0
    while i<n and j<m:
        if str1[i]==str2[j]:
            count+=1
        i+=1
        j+=1
    return count

str1=input()
str2=input()
print(CountCharacter(str1.lower(),str2.lower()))