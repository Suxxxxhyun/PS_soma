def solution(n, computers):
  def dfs(com):
    visited[com] = True

    for i in range(n):
      if not visited[i] and computers[com][i] == 1:
        dfs(i)

  visited = [False] * (n+1)
  answer = 0

  for i in range(n):
    for j in range(n):
      if not visited[i] and computers[i][j] == 1:
        dfs(i)
        answer += 1

  return answer
