N, M = map(int, input().split())
num = []

def dfs(start):
  if len(num) == M:
    print(' '.join(map(str, num)))
    return

  for i in range(start, N+1):
    num.append(i)
    dfs(i)
    num.pop()

dfs(1)
