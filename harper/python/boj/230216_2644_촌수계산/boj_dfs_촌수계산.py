n = int(input())
family = [[] * (n+1) for _ in range(n+1)]
x, y = map(int, input().split())
m = int(int(input()))
visited = [False] * (n+1)
for _ in range(m):
  a, b = map(int, input().split())
  family[a].append(b)
  family[b].append(a)

result = -1
def dfs(target, cnt):
  global result
  if target == y:
    result = cnt
    return

  visited[target] = True

  for child in family[target]:
    if not visited[child]:
      dfs(child, cnt+1)

dfs(x, 0)
print(result)
