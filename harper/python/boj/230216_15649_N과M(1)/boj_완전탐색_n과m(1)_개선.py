n, m = map(int, input().split())
answer = []
check = [False] * (n+1)
def dfs():
  if len(answer) == m:
    print(' '.join(map(str, answer)))
    return

  for i in range(1, n+1):
    if i in answer:
      continue
    answer.append(i)
    dfs()
    answer.pop()

dfs()


