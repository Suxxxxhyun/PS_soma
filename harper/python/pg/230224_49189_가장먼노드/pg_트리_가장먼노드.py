from collections import deque
def solution(n, vertex):
  answer = 0

  tree = [[] * (n+1) for _ in range(n+1)]
  distance = [-1] * (n+1)

  for i in range(len(vertex)):
    a, b = vertex[i]
    tree[a].append(b)
    tree[b].append(a)

  queue = deque()
  queue.append(1)
  distance[1] = 1

  while queue:
    start = queue.popleft()
    for next in tree[start]:
      if distance[next] == -1: ####### 다음 노드가 방문하지 않았으면
        distance[next] = distance[start] + 1
        queue.append(next)


  max_value = max(distance)
  print(distance)

  for i in range(1, n+1):
    if max_value == distance[i]:
      answer += 1
  return answer
