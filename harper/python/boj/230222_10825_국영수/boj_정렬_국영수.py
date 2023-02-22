n = int(input())
student = []
for i in range(n):
  student.append(list(input().split()))


student.sort(key= lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in range(n):
  print(student[i][0])
