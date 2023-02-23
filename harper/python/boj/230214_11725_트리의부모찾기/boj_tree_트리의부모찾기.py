n = int(input())
tree = [[] for _ in range(n+1)]
parent = [-1] * (n+1)

for i in range(n-1):
  a, b = map(int, input().split())
  tree[a].append(b)
  tree[b].append(a)

def dfs(idx):

  if idx == n:
    return

  for next in tree[idx]:
    if parent[next] == -1:
      parent[next] = idx
      dfs(next)

dfs(1)
for i in range(2, n+1):
  print(parent[i])
