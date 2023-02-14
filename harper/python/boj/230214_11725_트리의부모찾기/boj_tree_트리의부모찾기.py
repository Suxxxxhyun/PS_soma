import sys
sys.setrecursionlimit(10**6)

n = int(input())
tree = [[] for _ in range(n+1)]
parent = [-1] * (n+1)

for _ in range(n-1):
  a, b = map(int, input().split())
  tree[a].append(b)
  tree[b].append(a)

def dfs(node):
  for new_node in tree[node]:
    if parent[new_node] == -1:
      parent[new_node] = node #직전 노드 기록 저장
      dfs(new_node)

dfs(1)

for i in range(2, n+1):
  print(parent[i])

