n, s = map(int, input().split())
arr = list(map(int, input().split()))
result = 0
def dfs(idx, sum):
  global result
  if idx >= n:
    return

  sum += arr[idx]

  if sum == s: #더해주고 난 다음에 타겟이 맞는지 비교해야했음
    result += 1

  dfs(idx+1, sum)
  dfs(idx+1, sum - arr[idx]) #직전에 더한거 빼주기

dfs(0, 0)
print(result)
