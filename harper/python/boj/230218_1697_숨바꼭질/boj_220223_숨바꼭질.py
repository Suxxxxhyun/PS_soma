from collections import deque
n, k = map(int, input().split())
MAX = 100001
second = [0] * MAX

queue = deque()
queue.append(n)

while queue:
  start = queue.popleft()
  if start == k:
    print(second[start])
    break
  for step in [start-1, start+1, start*2]:
    if 0<=step<MAX and second[step] == 0:
      second[step] = second[start] + 1
      queue.append(step)

