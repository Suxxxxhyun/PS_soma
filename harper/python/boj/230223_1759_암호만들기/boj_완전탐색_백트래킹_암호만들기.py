l, c = map(int, input().split())
alpha = list(input().split())
alpha.sort()
result = []

def dfs(list, idx):

  if len(list) == l:
    password = "".join(map(str, list))
    vo, co = 0, 0
    for i in range(l):
      if password[i] in cons:
        vo += 1
      else:
        co += 1
    if vo>=1 and co>=2:
      print(password)
    return

  for i in range(idx, c): #같은걸 고르면 안되기 때문에 idx부터 증가
    list.append(alpha[i])
    dfs(list, i+1)
    list.pop()

cons = ['a', 'e', 'i', 'o', 'u']
dfs([], 0)
