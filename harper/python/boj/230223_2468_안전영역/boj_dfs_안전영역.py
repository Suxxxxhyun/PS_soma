import sys
sys.setrecursionlimit(10**6)

n = int(input())
ground = [list(map(int, input().split())) for _ in range(n)]
result = -1e9

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def dfs(x, y, h):
  visited[x][y] = True
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<n and 0<=ny<n and not visited[nx][ny] and ground[nx][ny] >= h:
      dfs(nx, ny, h)

for height in range(1, 101):
  cnt = 0
  visited = [[False] * n for _ in range(n)]

  for x in range(n):
    for y in range(n):
      if ground[x][y] >= height and not visited[x][y]:
        dfs(x, y, height)
        cnt += 1

  result = max(result, cnt)

print(result)
