'''
개선버전
가장 긴 노드를 찾고
해당 노드로 탐색했을 때 간선의 길이 중 젤 긴 것 반환
'''

import sys
sys.setrecursionlimit(10**9)
n = int(input())
tree = [[] for _ in range(n+1)]
def dfs(x, distance):
  for i, d in tree[x]:
    if distance[i] == 0:
      distance[i] = distance[x] + d
      dfs(i, distance)

for _ in range(n-1):
  a, b, distance = map(int, input().split())
  tree[a].append((b, distance))
  tree[b].append((a, distance))

result = 0
distance = [0] * (n+1)
dfs(1, distance)
index = 0

for i in range(n+1):
  if result < distance[i]:
    result = distance[i]
    index = i

distance = [0] * (n+1)
distance[1] = 0
dfs(index, distance)
distance[index] = 0
print(max(distance))
