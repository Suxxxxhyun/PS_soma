from collections import deque

'''
visited를 true/false로만 생각하면 방문했지만 다시 인구이동이 일어나야할 때 계산하지 못함 
노드 방문을 체크하는 배열, 평균값 계산을 위해 해당되는 연합들의 좌표 저장 배열, 상하좌우 순회를 위한 큐를 정의해야함 
탈출조건을 생각하는 것도 어려웠음 
'''
n, l, r = map(int, input().split())
nation = [[0] * n for _ in range(n)]
for i in range(n):
  nation[i] = list(map(int, input().split()))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
def bfs(x, y, cnt):
  union = []
  queue = deque()
  union.append((x, y))
  queue.append((x, y))
  visited[x][y] = cnt
  union_count = 1

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0<=nx<n and 0<=ny<n and visited[nx][ny] == -1:
        if l<=abs(nation[nx][ny] - nation[x][y])<=r:
          queue.append((nx, ny))
          visited[nx][ny] = cnt
          union_count +=1
          union.append((nx, ny))
  sum = 0
  for i, j in union:
    sum += nation[i][j]
  for i, j in union:
    nation[i][j] = sum // union_count

result = 0

while True:
  visited = [[-1] * n for _ in range(n)]
  cnt = 0
  for i in range(n):
    for j in range(n):
      if visited[i][j] == -1:
        bfs(i, j, cnt)
        cnt += 1
  if cnt == n*n: #탈출 조건
    break
  result += 1

print(result)
