def dp(n):
    d[1] = 1
    d[2] = 1
    for i in range(3, n + 1):
        d[i] = d[i - 3] + d[i - 2]
    return d[n]

t = int(input())
for _ in range(t):
    n = int(input())
    d = [0] * 101
    print(dp(n))
