n, s = map(int, input().split())
num = list(map(int, input().split()))
result = 0
sum_value = 0

def dfs(idx, sum):
  global result

  if idx >= n:
    return
  sum += num[idx]
  if sum == s:
    result += 1

  dfs(idx+1, sum)
  dfs(idx+1, sum-num[idx]) #더해준 만큼 빼주기

dfs(0, 0)
print(result)
