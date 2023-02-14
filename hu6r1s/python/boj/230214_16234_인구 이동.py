'''
DFS로 풀이하고 있는 중..
메모리 관련 에러가 나와서 나중에 다시 풀어볼 것.
'''

import sys
sys.setrecursionlimit(10 ** 6)

def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    if l <= graph[x][y] <= r:
        visited[x][y] = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)
        return True

    return False


n, l, r = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
result = 0
arr = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, -1]
visited = [[0] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            if visited[i][j] == 1:
                arr.append(graph[i][j])
print(visited)
print(arr)
