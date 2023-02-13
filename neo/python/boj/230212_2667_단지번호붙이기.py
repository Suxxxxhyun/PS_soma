def dfs(x, y):
    global count
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        count += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)
        return True
    return False


n = int(input())
graph = []
num = []
count = 0
result = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(n):
    graph.append(list(map(int, input())))

for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            result += 1
            num.append(count)
            count = 0
print(result)
num.sort()
for i in num:
    print(i)
