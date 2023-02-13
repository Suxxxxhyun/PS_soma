from collections import deque
n, m = map(int, input().split())
maze = [[0] * m for _ in range(n)]
for i in range(n):
  maze[i] = list(map(int, input()))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

queue = deque()
def bfs(i, j):
  queue.append((i, j))
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0<=nx<n and 0<=ny<m and maze[nx][ny] == 1:
        maze[nx][ny] = maze[x][y] + 1
        queue.append((nx, ny))

bfs(0, 0)
print(maze[n-1][m-1])
