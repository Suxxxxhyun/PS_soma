'''
1. 반복되면서 횟수를 카운트 하는 것을 변수에만 저장하지 말고 배열에 넣어서 진행해 볼 것
   bfs 특징 살려서
2. 문제에 범위 주어져있으면 반드시 체크할 것 N(0 ≤ N ≤ 100,000)
'''

from collections import deque
n, k = map(int, input().split())
MAX = 100001
dist = [0] * MAX
queue = deque([n])

while queue:
  start = queue.popleft()
  if start == k:
    print(dist[start])
    break
  for next in [start-1, start+1, start*2]: #배열 만들지 않고 이렇게 정의 가능
    if 0<=next<MAX and not dist[next]: # if not은 false 말고 정수로 했을때 0을 의미 
      dist[next] = dist[start] + 1
      queue.append(next)
