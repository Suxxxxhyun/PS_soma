n, m = map(int, input().split())
list = []
def dfs():
  if len(list) == m:
    print(" ".join(map(str, list))) #공백을 사이에 두고 출력
    return

  for i in range(1, n+1): #1부터 n까지
    if i not in list: # 중복없이
      list.append(i)
      dfs()
      list.pop()

dfs()
