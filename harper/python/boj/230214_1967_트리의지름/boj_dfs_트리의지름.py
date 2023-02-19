import sys
sys.setrecursionlimit(10**9)
n = int(input())
tree = [[] for _ in range(n+1)]
def dfs(x, distance):
  for i, d in tree[x]:
    if distance[i] == 0:
      distance[i] = distance[x] + d
      dfs(i, distance)

for _ in range(n-1):
  a, b, distance = map(int, input().split())
  tree[a].append((b, distance))
  tree[b].append((a, distance))

result = -1e9

for i in range(1, n+1):
  distance = [0] * (n+1)
  dfs(i, distance)
  distance.sort()
  result = max(result, distance[n])

print(result)
