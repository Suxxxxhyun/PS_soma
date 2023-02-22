n = int(input())
student = []
for i in range(n):
  student.append((input().split()))

student.sort(key=lambda x: x[1])

for i in student:
  print(i[0], end = ' ')
