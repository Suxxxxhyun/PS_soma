s = input().split('-')
result = []
for i in s:
  n = 0
  a = i.split('+')
  for j in a:
    n += int(j)
  result.append(n)
a = result[0]
for i in range(1, len(result)):
  a -= result[i]
print(a)
