n, w = map(int, input().split())
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
  a, b = map(int, input().split())
  tree[a].append(b)
  tree[b].append(a)

leaf_cnt = 0
for node in range(2, n+1):
  if len(tree[node]) == 1:
    leaf_cnt += 1


