n, m = map(int, input().split())
card = list((map(int, input().split())))
list = [] * m
answer = 0

def pick(start):
  global answer
  if len(list) == 3:
    sum_list = sum(list)
    if sum_list <= m:
      answer = max(answer, sum_list)
    return

  for i in card:
    if i not in list:
      list.append(i)
      pick(i+1)
      list.pop()

pick(0)
print(answer)
