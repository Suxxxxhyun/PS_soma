import sys
sys.setrecursionlimit(10 ** 6)

from collections import deque
n, k = map(int, input().split())
MAX = 100001
dist = [-1] * MAX

queue = deque([n])
dist[n] = 0
while queue:
  start = queue.popleft()
  if start == k:
    print(dist[start])
    break
  if 0<=start*2<MAX and dist[start*2] == -1:
    dist[start*2] = dist[start]
    queue.appendleft(start*2)
  if 0<=start+1<MAX and dist[start+1] == -1:
    dist[start+1] = dist[start] + 1
    queue.append(start+1)
  if 0<=start-1<MAX and dist[start-1] == -1:
    dist[start-1] = dist[start] + 1
    queue.append(start-1)


