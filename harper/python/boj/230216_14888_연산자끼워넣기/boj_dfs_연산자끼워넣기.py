n = int(input())
number = list(map(int, input().split()))
plus, minus, mul, div = map(int, input().split())

max_value = -1e9
min_value = 1e9

def dfs(index, sum_value):
  global min_value, max_value, plus, minus, mul, div

  if index == n:
    min_value = min(min_value, sum_value)
    max_value = max(max_value, sum_value)

  if plus>0:
    plus-=1
    dfs(index+1, sum_value + number[index])
    plus+=1
  if minus>0:
    minus-=1
    dfs(index+1, sum_value - number[index])
    minus+=1
  if mul>0:
    mul-=1
    dfs(index+1, sum_value * number[index])
    mul+=1
  if div>0:
    div-=1
    dfs(index+1, int(sum_value/number[index]))
    div+=1

dfs(1, number[0])
print(max_value)
print(min_value)
