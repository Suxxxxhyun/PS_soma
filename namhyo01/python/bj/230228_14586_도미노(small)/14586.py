import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline
# ㅁㅊ 고려대 문제구나 ㅇㅅㅇ..
n = int(input())
dominos = []
dp = [[-1 for _ in range(n+1)] for _ in range(n+1)] # 0 : 왼쪽, 1 : 오른쪽
for _ in range(n):
    dominos.append(list(map(int, input().split())))
dominos.sort() # 순서대로 오게 정렬
x_list = [i[0] for i in dominos]
h_list = [i[1] for i in dominos]

leftdp = [-1 for _ in range(n+1)]
rightdp = [-1 for _ in range(n+1)]
inf = 2000000001

def left(cur):

    if leftdp[cur] != -1:
        return leftdp[cur]
    x,h = dominos[cur][0], dominos[cur][1]
    move = x-h
    temp = bisect_left(x_list,move)
    leftdp[cur] = temp
    for i in range(temp,cur): # 자신이 밀쳐내는 것 들 중에서 더 멀리 밀쳐내면 그 값으로 갱신한다
        leftdp[cur] = min(leftdp[cur], left(i))

    return leftdp[cur]

def right(cur):
    if rightdp[cur] != -1:
        return rightdp[cur]
    x,h = dominos[cur][0], dominos[cur][1]
    move = x+h
    temp = bisect_right(x_list,move)

    rightdp[cur] = temp-1
    for i in range(cur,temp): # 자신이 밀쳐내는 것 들 중에서 더 멀리 밀쳐내면 그 값으로 갱신한다
        rightdp[cur] = max(rightdp[cur], right(i))
    return rightdp[cur]

for i in range(n):
    left(i)
    right(i)

def solve(start,end):
    if dp[start][end] != -1:
        return dp[start][end]
    # 기저조건이 뭐가 있을까 생각이 안난다
    if start>end:
        dp[start][end] = 0
        return 0

    if rightdp[start]>=end or leftdp[end]<=start:
        dp[start][end] = 1
        return dp[start][end]
    dp[start][end] = float('inf')
    for i in range(start,end+1):
        dp[start][end] = min(dp[start][end], solve(start,leftdp[i]-1)+solve(leftdp[i],rightdp[i])+solve(rightdp[i]+1,end))
    return dp[start][end]

print(leftdp)
print(rightdp)
print(solve(0,n-1))
    
    
    