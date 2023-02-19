N, M = map(int, input().split())
num = []

def dfs(start):
  if len(num) == M:
    print(' '.join(map(str, num)))
    return

  for i in range(start, N+1):
    if i in num: #중복제거
      continue
    num.append(i)
    dfs(i+1)
    num.pop()

dfs(1)
