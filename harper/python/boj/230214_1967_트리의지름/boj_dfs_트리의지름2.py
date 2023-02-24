import sys
sys.setrecursionlimit(10**9)
n = int(input())
tree = [[] * (n+1) for _ in range(n+1)]

for i in range(n-1):
  a, b, weight = map(int, input().split())
  tree[a].append((b, weight))
  tree[b].append((a, weight))

def dfs(start): #distance에 표시하는게 역할이야
  visited[start] = True
  for next, weight in tree[start]:
    if not visited[next] and distance[start] != -1:
      distance[next] = distance[start] + weight
      dfs(next)


visited = [False] * (n+1)
distance = [-1] * (n+1)
distance[1] = 0
dfs(1)
max_value = 0
max_index = 0

for i in range(1, n+1):
  if max_value < distance[i]:
    max_value = distance[i]
    max_index = i

distance = [-1] * (n+1)
visited = [False] * (n+1)
distance[max_index]  = 0
dfs(max_index)

print(max(distance))
