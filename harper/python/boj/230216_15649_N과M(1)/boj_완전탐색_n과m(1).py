n, m = map(int, input().split())
answer = [0] * (m)
check = [False] * (n+1)
def combination(num):
  if num == m:
    print(*answer)
    return

  for i in range(1, n+1):
    if check[i] == False:
      check[i] = True
      answer[num] = i
      combination(num+1)
      check[i] = False

combination(0)


