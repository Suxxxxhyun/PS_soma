n, m = map(int, input().split())
r, c, direction = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]
temp = [[0] * m for _ in range(n)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

def clean(r, c, direction):
  if room[r][c] == 0:
    room[r][c] = -1
  for _ in range(4):
    nd = (direction + 3) % 4
    nx = r + dr[nd]
    ny = c + dc[nd]
    if 0<=nx<n and 0<=ny<m and room[nx][ny] == 0:
      clean(nx, ny, nd)
      return
    direction = nd
  nd = (direction + 2) % 4
  nx = r + dr[nd]
  ny = c + dc[nd]
  if room[nx][ny] == 1:
    return
  clean(nx, ny, direction)

clean(r, c, direction)

cnt = 0
for i in range(n):
  for j in range(m):
    if room[i][j] == -1:
      cnt += 1
print(cnt)



