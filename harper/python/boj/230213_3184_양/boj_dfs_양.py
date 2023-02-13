#import sys
#sys.setrecursionlimit(10**6)

#양을 죽이는걸 못하고 있음

r, c = map(int, input().split())
yard = [[] * c for _ in range(r)]
for i in range(r):
  yard[i] = list(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
  global sheep, wolf
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    while 0<=x<r and 0<=y<c and yard[x][y] != '#' and yard[x][y] != '.':
      if yard[x][y] == 'o':
        sheep += 1
      if yard[x][y] == 'v':
        wolf += 1
      yard[x][y] = '.'
      nx += dx[i]
      ny += dy[i]
      return True
  return False

alive_sheep, alive_wolf = 0, 0
for i in range(r):
  for j in range(c):
    sheep, wolf = 0, 0
    if yard[i][j] != '#':
      if dfs(i, j):
        if sheep > wolf:
          alive_sheep += sheep
        else:
          alive_wolf += wolf

print(alive_sheep, alive_wolf)
