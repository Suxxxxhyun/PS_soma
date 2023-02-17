'''
1. 벽을 만나면 탐색을 중지해야 함
2. 탐색 할 울타리 마다 양과 늑대의 수를 초기화 해줘야 함
'''
import sys
sys.setrecursionlimit(10 ** 6)
n, m = map(int, input().split())
yard = [ [] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
total_wolf, total_sheep = 0, 0

for i in range(n):
  yard[i] = list(input())
  for j in range(m):
    if yard[i][j] == 'v':
      total_wolf += 1
    elif yard[i][j] == 'o':
      total_sheep += 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

sheep, wolf = 0, 0
visited = [[False] * m for _ in range(n)]
def dfs(x, y):
  global wolf, sheep
  visited[x][y] = True
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<n and 0<=ny<m and visited[nx][ny] == False and yard[nx][ny] != '#':
      if yard[nx][ny] == 'o':
        sheep += 1
      if yard[nx][ny] == 'v':
        wolf += 1
      dfs(nx, ny)

for i in range(n):
  for j in range(m):
    wolf, sheep = 0, 0
    if yard[i][j] == 'o':
      sheep += 1
      dfs(i, j)
      if wolf >= sheep:
        total_sheep -= sheep
      else:
        total_wolf -= wolf

print(total_sheep, total_wolf)
