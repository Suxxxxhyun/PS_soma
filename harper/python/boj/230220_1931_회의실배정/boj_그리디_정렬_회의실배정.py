n = int(input())
list = [[0] * 2 for _ in range(n)]
for i in range(n):
  start, end = map(int, input().split())
  list[i][0] = start
  list[i][1] = end

list.sort(key=lambda x: (x[1], x[0]))

result = 0
first_end = list[0][1]
for i in range(1, n):
  if list[i][0] >= first_end:
    first_end = list[i][1]
    result += 1
print(result+1)
