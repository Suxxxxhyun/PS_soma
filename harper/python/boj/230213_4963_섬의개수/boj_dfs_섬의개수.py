import sys
sys.setrecursionlimit(10000)

dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]
def dfs(x, y):
  for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<h and 0<=ny<w:
      if island[nx][ny] == 1:
        island[nx][ny] = -1
        dfs(nx, ny)

while True:
  w, h = map(int, input().split())
  if w == 0 and h == 0:
    break

  island = [[0] * w for _ in range(h)]
  for i in range(h):
    island[i] = list(map(int, input().split()))
  cnt = 0

  for i in range(h):
    for j in range(w):
      if island[i][j] == 1:
        dfs(i, j)
        cnt += 1

  print(cnt)


