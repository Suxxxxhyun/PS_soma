import sys
input = sys.stdin.readline

while True:
  ss = input().rstrip()
  if not ss:
    break
  s, t = ss.split()
  flag = 0
  idx = 0

  for i in range(len(t)):
    if t[i] == s[idx]:
      idx+=1
      if idx == len(s):
        flag = 1
        break

  if flag == 1:
    print('Yes')
  else:
    print('No')
