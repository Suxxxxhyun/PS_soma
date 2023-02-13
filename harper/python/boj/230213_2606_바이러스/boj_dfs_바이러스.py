computer = int(input())
n =int(input())
network = [[] * computer for _ in range(computer+1)]
visited = [0] * (computer+1)

for _ in range(n):
  a, b = map(int, input().split())
  network[a].append(b)
  network[b].append(a)

cnt = 0
def dfs(x):
  global cnt
  visited[x] = 1
  for computer in network[x]:
    if visited[computer] == 0:
      dfs(computer)
      cnt += 1

dfs(1)
print(cnt)

