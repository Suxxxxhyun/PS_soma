'''
500 * 500 dfs 탐색 -> 메모리 초과
도착지점까지 가는 경우의 수는 임의의 점에서 도착지점까지 가는 경우의 수를 합한 것과 같음 -> dp 활용

'''
N, M = map(int, input().split())
route = [[] * M for _ in range(N)]
dp = [[-1] * M for _ in range(N)]
for i in range(N):
  route[i] = list(map(int, input().split()))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def dfs(x, y):
  global cnt
  if x == N-1 and y == M-1:
    return 1 #경우의 수 1가지

  if dp[x][y] != -1: # 방문한 적이 있으면 그 위치에서 출발하는 경우의 수를 리턴
    return dp[x][y]

  dp[x][y] = 0

  ways = 0
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0<=nx<N and 0<=ny<M and route[x][y] > route[nx][ny]:
      ways += dfs(nx, ny) #해당 지점부터 갈 수 있는 경로의 수를 업데이트
  dp[x][y] = ways

  return dp[x][y]

print(dfs(0, 0))

