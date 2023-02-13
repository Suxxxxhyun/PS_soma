import copy
from itertools import combinations
n, m = map(int, input().split())
lab = [[] * m for _ in range(n)]
wall = []

for i in range(n):
  lab[i] = list(map(int, input().split()))

for i in range(n):
  for j in range(m):
    if lab[i][j] == 0:
      wall.append((i, j))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
def dfs(x, y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<n and 0<=ny<m and tmp[nx][ny] == 0:
      tmp[nx][ny] = 2
      dfs(nx, ny)

max_value = 0

for candidates in list(combinations(wall, 3)):
  for candidate in candidates:
    x, y = candidate
    lab[x][y] = 1

  tmp = copy.deepcopy(lab)

  for i in range(n):
    for j in range(m):
      if tmp[i][j] == 2:
        dfs(i, j)

  safe_zone = 0
  for i in range(n):
    for j in range(m):
      if tmp[i][j] == 0:
        safe_zone += 1

  max_value = max(max_value, safe_zone)

  for candidate in candidates:
    x, y = candidate
    lab[x][y] = 0

print(max_value)
