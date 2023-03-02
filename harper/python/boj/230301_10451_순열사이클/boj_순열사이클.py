'''
트리 탐색과 비슷한 문제
dfs 함수 내부에서는 visited여부만 체크
'''
for i in range(int(input())):
  N = int(input())
  numbers = [0] + list(map(int, input().split()))
  visited = [False] * (N+1)
  cnt = 0
  def dfs(node):
    visited[node] = True
    next_node = numbers[node]
    if not visited[next_node]:
      dfs(next_node)

  for j in range(1, N+1):
    if not visited[j]:
      dfs(j)
      cnt += 1

  print(cnt)

