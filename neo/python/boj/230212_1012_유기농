import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)
        return True
    return False


t = int(input())

for _ in range(t):
    m, n, k = map(int, input().split())
    graph = [[0] * m for i in range(n)]
    result = 0
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1
    for i in range(n):
        for j in range(m):
            if dfs(i, j) == True:
                result += 1
    print(result)
