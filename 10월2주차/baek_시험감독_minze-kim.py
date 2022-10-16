import sys, math
input = sys.stdin.readline

N = int(input())
A = list(map(int,input().split()))
B, C = map(int,input().split())

answer = 0

for a in A:
    if a <= B:
        answer += 1
    else:
        answer += ((math.ceil((a-B)/C)) + 1)
print(answer)