from collections import deque
n, m = map(int, input().split())
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
  a, b, distance = map(int, input().split())
  tree[a].append((b, distance))
  tree[b].append((a, distance))

def bfs(start, end):
  queue = deque()
  queue.append(start)
  visited = [-1] * (n+1)
  visited[start] = 0
  while queue:
    print(visited)
    x = queue.popleft()
    if x == end: # 탈출 조건 파악 못함
      break
    for next_node, distance in tree[x]:
      visited[next_node] = visited[x] + distance
      queue.append(next_node)
  return visited[end]

for i in range(m):
  a, b = map(int, input().split())
  print(bfs(a, b))

