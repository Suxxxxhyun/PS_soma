import sys
input = sys.stdin.readline

n, w = map(int, input().split())
graph = [[] for _ in range(n + 1)]
count = 0
for _ in range(n - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(2, n + 1):
    if len(graph[i]) == 1:
        count += 1
print(round(w / count, 10))
