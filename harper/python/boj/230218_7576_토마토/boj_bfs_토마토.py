from collections import deque
m, n = map(int, input().split())
queue = deque()
box = [list(map(int, input().split())) for _ in range(n)]
zero = False
for i in range(n):
  for j in range(m):
    if box[i][j] == 0:
      zero = True

if not zero:
  print(0)
  exit()

for i in range(n):
  for j in range(m):
    if box[i][j] == 1:
      queue.append((i, j, 0))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
day = 0
flag = False

while queue:
  x, y, day = queue.popleft()
  day += 1
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<n and 0<=ny<m and box[nx][ny] == 0:
      box[nx][ny] = day
      queue.append((nx, ny, day))

for i in range(n):
  for j in range(m):
    if box[i][j] == 0:
      print(-1)
      exit()

print(day-1)

