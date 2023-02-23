from collections import deque
'''
최단거리가 2여야함 그냥 가는길이 2면 다 출력하고 있음 
-> distance 배열 하나에 다 저장하면 시작하는 노드로부터의 최단거리가 모두 저장됨 
-> 다시풀기
'''
n,m,k,x = map(int, input().split())
tree = [[] * (n+1) for _ in range(n+1)]
distance = [-1] * (n+1)
for i in range(m):
  a, b = map(int, input().split())
  tree[a].append(b)

queue = deque()
queue.append(x)
distance[x] = 0

while queue:
  node = queue.popleft()
  for next in tree[node]:
    if distance[next] == -1:
      distance[next] = distance[node] + 1
      queue.append(next)
flag = False
for i in range(1, n+1):
  if distance[i] == k:
    print(i)
    flag = True
if not flag:
  print(-1)
