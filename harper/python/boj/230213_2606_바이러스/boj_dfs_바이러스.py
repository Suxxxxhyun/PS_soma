

def dfs(com):
  global cnt
  visited[com] = True

  for i in network[com]:
    if not visited[i]:
      dfs(i)
      cnt += 1

computer = int(input())
n = int(input())
cnt = 0
network = [[0] * (computer) for _ in range(computer+1)]
visited = [False] * (computer+1)
for _ in range(n):
  a, b = map(int, input().split())
  network[a].append(b)
  network[b].append(a)
f
dfs(1)
print(cnt-1)


