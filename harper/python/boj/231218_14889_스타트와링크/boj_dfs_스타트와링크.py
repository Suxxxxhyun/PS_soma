N = int(input())
power = [list(map(int, input().split())) for _ in range(N)]
people = [False for _ in range(N)]
diff = int(1e9)
def dfs(depth, idx):
  global diff
  if depth == N//2:
    start, link = 0, 0
    for i in range(N):
      for j in range(N):
        if people[i] and people[j]:
          start += power[i][j]
        elif not people[i] and not people[j]:
          link += power[i][j]
    diff = min(diff, abs(start-link))
    return

  for i in range(idx, N):
    if not people[i]:
      people[i] = True
      dfs(depth+1, i+1)
      people[i] = False

dfs(0, 0)
print(diff)
