for i in range(int(input())):
  N = int(input())
  nodes = [0] + list(map(int,input().split()))
  visited = [False] * (N+1)
  cnt = 0
  def dfs(node, start):
    visited[node] = True
    if node == nodes[node]: #자기 자신을 가리키는 그래프
      return
    if start == nodes[node]: #다시 처음 가리키던 방향으로 돌아오면
      return
    dfs(nodes[node], start)

  for i in range(1, N+1):
    if not visited[i]:
      dfs(i, i)
      cnt += 1
  print(cnt)
