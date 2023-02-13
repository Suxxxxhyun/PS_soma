from collections import deque

n, k = map(int, input().split())
lab = [[0] * n for _ in range(n)]
for i in range(n):
  lab[i] = list(map(int, input().split()))
s, a, b = map(int, input().split())

virus = []
for i in range(n):
  for j in range(n):
    if lab[i][j] != 0:
      virus.append((lab[i][j], i, j, 0))

virus.sort()
queue = deque(virus)

second = 0
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

while queue:
  virus, x, y, time = queue.popleft()
  if time == s:
    break
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<n and 0<=ny<n and lab[nx][ny] == 0:
      lab[nx][ny] = virus
      queue.append((virus, nx, ny, time+1))

print(lab[a-1][b-1])
