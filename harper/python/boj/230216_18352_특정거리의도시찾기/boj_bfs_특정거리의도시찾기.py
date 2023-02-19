from collections import deque
import sys

input = sys.stdin.readline

n, m, k, x = map(int, input().split())
city = [[] for _ in range(n+1)]

for _ in range(m):
  a, b = map(int, input().split())
  city[a].append(b)

queue = deque([x])

x_distance = [-1] * (n+1)
x_distance[x] = 0

while queue:
  x = queue.popleft()
  for i in city[x]:
    if x_distance[i] == -1:
      x_distance[i] = x_distance[x] + 1
      queue.append(i)

flag = False

for i in range(1, n+1):
  if x_distance[i] == k:
    print(i)
    flag = True

if not flag:
  print(-1)
