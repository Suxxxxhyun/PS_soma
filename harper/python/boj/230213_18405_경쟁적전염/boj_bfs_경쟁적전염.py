from collections import deque

n, k = map(int, input().split())
lab = [[0] * n for _ in range(n)]
for i in range(n):
  lab[i] = list(map(int, input().split()))
s, x, y = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
list = []
for i in range(n):
  for j in range(n):
    if lab[i][j] != 0:
      list.append((lab[i][j], i, j, 0))

list.sort()
queue = deque(list)

while queue:
  virus, a, b, second = queue.popleft()
  if s == second:
    break
  for i in range(4):
    nx = a + dx[i]
    ny = b + dy[i]
    if 0<=nx<n and 0<=ny<n and lab[nx][ny] == 0:
      # lab[nx][ny] = lab[a][b]
      lab[nx][ny] = virus
      queue.append((lab[nx][ny], nx, ny, second + 1))

print(lab[x-1][y-1])
