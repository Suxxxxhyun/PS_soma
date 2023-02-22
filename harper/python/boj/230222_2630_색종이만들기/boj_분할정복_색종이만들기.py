n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]

blue = 0
white = 0

def cutting(x, y, N):
  global white, blue
  color = paper[x][y]
  for i in range(x, x+N):
    for j in range(y, y+N):
      if color != paper[i][j]: #영역의 모든 색이 같지 않을 경우
        cutting(x, y, N//2)
        cutting(x+N//2, y, N//2)
        cutting(x, y+N//2, N//2)
        cutting(x+N//2, y+N//2, N//2)
        return
  if color == 0: #영역의 모든 색이 같을 경우
    white += 1
  else:
    blue += 1


cutting(0, 0, n)
print(white)
print(blue)
