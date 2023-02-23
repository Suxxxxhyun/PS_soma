from collections import deque
n, m = map(int, input().split())
tree = [[] * (n+1) for _ in range(n+1)]


for i in range(n-1):
  a, b, edge = map(int, input().split())
  tree[a].append((b, edge))
  tree[b].append((a, edge))

for i in range(m):
  start, end = map(int, input().split())
  queue = deque()
  queue.append(start)
  distance = [-1] * (n+1)
  visited = [False]  * (n+1)
  distance[start] = 0
  visited[start] = True

  while queue:
    node = queue.pop()
    visited[node] = True
    if node == end:
      print(distance[node])
    for next, weight in tree[node]:
      if distance[node] != -1 and not visited[next]:
        distance[next] = distance[node] + weight
        queue.append(next)
