from collections import deque
N, M, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

for time in range(r):
  x, y = 0, 0
  n, m = N, M
  depth = min(n, m) // 2
  while depth > 0: #안쪽까지
    temp = arr[x][y]
    for i in range(y, m-1): arr[x][i] = arr[x][i+1]
    for i in range(x, n-1): arr[i][m-1] = arr[i+1][m-1]
    for i in range(m-1, y, -1): arr[n-1][i] = arr[n-1][i-1]
    for i in range(n-1, x, -1): arr[i][y] = arr[i-1][y]
    arr[x+1][y] = temp
    x+=1
    y+=1
    n-=1
    m-=1
    depth -=1

for i in range(N):
  for j in range(M):
    print(arr[i][j], end=" ")
  print()
