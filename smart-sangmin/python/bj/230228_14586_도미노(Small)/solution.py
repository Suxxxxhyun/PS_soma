def hitleft(i):
    x = dom[i][0] - dom[i][1]
    for j in range(i-1, -1, -1):
        if dom[j][0] < x:
            return j+1
        x = min(x, dom[j][0] - dom[j][1])
    return 0


def hitright(i):
    x = dom[i][0] + dom[i][1]
    for j in range(i+1, n):
        if dom[j][0] > x:
            return j-1
        x = max(x, dom[j][0] + dom[j][1])
    return n-1


n = int(input())
"""
5
1 2
3 1
6 2
7 1
9 2
"""
dom = sorted(tuple(map(int, input().split())) for i in range(n))
L = [hitleft(i) for i in range(n)]
R = [hitright(i) for i in range(n)]

dp = [float('inf')] * n
dp[0] = 1

for i in range(n):
    dp[i] = min(dp[i], 1 + (dp[L[i]-1] if L[i]-1 >= 0 else 0))
    for j in range(i):
        if R[j] >= i:
            dp[i] = min(dp[i], 1 + (dp[j-1] if j-1 >= 0 else 0))
print(dp[0])
