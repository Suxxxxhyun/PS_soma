# m과 n이 바뀐 문제
# 최대 재귀 깊이 수정
import sys
sys.setrecursionlimit(10000)
def dfs(x, y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<m and 0<=ny<n:
      if farm[ny][nx] == 1:
        farm[ny][nx] = -1
        dfs(nx,ny)

t = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(t):
  m, n, k = map(int, input().split())
  farm = [[0] * m for _ in range(n)]

  for _ in range(k):
    x, y = map(int, input().split())
    farm[y][x] = 1

  worm = 0
  for i in range(m):
    for j in range(n):
      if farm[j][i] == 1:
        dfs(i, j)
        worm += 1

  print(worm)
