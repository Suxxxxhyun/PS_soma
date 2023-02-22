n = int(input())
number = []
for i in range(n):
  number.append(int(input()))
number.sort(reverse=True)
for i in number:
  print(i, end = ' ')
