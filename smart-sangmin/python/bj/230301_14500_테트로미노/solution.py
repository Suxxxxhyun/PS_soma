def dfs(y, x, cnt, SUM):
    if cnt == 0:
        return SUM
    ret = -1
    directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    for i in range(4):
        moveY, moveX = directions[i]
        movedY = y + moveY
        movedX = x + moveX
        if 0 <= movedY < N and 0 <= movedX < M and not visited[movedY][movedX]:
            if cnt == 2:
                visited[movedY][movedX] = True
                ret = max(dfs(y, x, cnt-1,
                              SUM+paper[movedY][movedX]), ret)
                visited[movedY][movedX] = False
            visited[movedY][movedX] = True
            ret = max(dfs(movedY, movedX, cnt-1,
                          SUM+paper[movedY][movedX]), ret)
            visited[movedY][movedX] = False
    return ret


N, M = map(int, input().split())
paper = []
visited = [[False] * M for _ in range(N)]
for i in range(N):
    paper.append(list(map(int, input().split())))
answer = 0
for i in range(N):
    for j in range(M):
        visited[i][j] = True
        answer = max(dfs(i, j, 3, paper[i][j]), answer)
        visited[i][j] = False
print(answer)
