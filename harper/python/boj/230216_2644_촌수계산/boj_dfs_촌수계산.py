n = int(input())
a, b = map(int, input().split())
m = int(input())

family = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
  x, y = map(int, input().split())
  family[x].append(y)
  family[y].append(x)

result = -1

def dfs(idx, num):
  global result

  if idx == b:
    result = num
    return

  num += 1 #촌수계산
  visited[idx] = True

  for i in family[idx]:
    if not visited[i]:
      dfs(i, num)

dfs(a, 0)
print(result)
