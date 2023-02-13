n = int(input())
home = [[0] * n for _ in range(n)]
for i in range(n):
  home[i] = list(map(int, input()))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
estate = []
cnt = 0
def dfs(x, y):
  global cnt
  cnt += 1
  home[x][y] = 0
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<n and 0<=ny<n and home[nx][ny] == 1:
      dfs(nx, ny)

for i in range(n):
  for j in range(n):
    if home[i][j] == 1:
      dfs(i, j)
      estate.append(cnt)
      cnt = 0

print(len(estate))
estate.sort()
for h in estate:
  print(h)
