def remov(row, col, s):
    visit[row][col] = 0
    direction = (-1, 0), (1, 0), (0, -1), (0, 1)
    for i in range(4):
        move_row, move_col = direction[i]
        moved_row = (move_row * s) + row
        moved_col = (move_col * s) + col
        visit[moved_row][moved_col] = 0


def check(row, col):
    direction = (-1, 0), (1, 0), (0, -1), (0, 1)
    scale = 0
    flag = False
    while True:
        for i in range(4):
            move_row, move_col = direction[i]
            moved_row = (move_row * (scale + 1)) + row
            moved_col = (move_col * (scale + 1)) + col
            if 0 > moved_row or moved_row >= N or 0 > moved_col or moved_col >= M or painting[moved_row][moved_col] != "*":
                flag = True
                break
        if flag:
            break
        scale += 1
    return scale


painting = []  # 입력받는거
N, M = map(int, input().split())
for i in range(N):
    painting.append(list(input()))

visit = [[0] * M for _ in range(N)]  # 입력받은 *이 십자가를 그려서 사라질 수 있는지 확인하는 변수
for i in range(N):
    for j in range(M):
        if painting[i][j] == '*':
            visit[i][j] = 1

answer = []
for i in range(N):
    for j in range(M):
        if painting[i][j] == '*':
            scale = check(i, j)  # 십자가와 사이즈를 찾는 로직
            if scale == 0:
                continue
            for s in range(scale, 0, -1):  # 십자가 사이즈 하나씩 줄이면서 visit에 1 지우는거 ex) 3 -> 2 -> 1
                remov(i, j, s)  # 실제 지우는 함수
                answer.append([i+1, j+1, s])  # 십자가 리스트
is_can = True
for i in range(N):
    for j in range(M):
        if visit[i][j] == 1:  # visit에 1이 있다면 십자가로만 주어진 *을 그릴 수 없는 경우임
            is_can = False

if is_can:
    print(len(answer))
    for ans in answer:
        print(*ans)
else:
    print(-1)
