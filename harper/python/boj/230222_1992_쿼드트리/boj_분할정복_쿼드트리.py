n = int(input())
video = [list(map(int, input())) for _ in range(n)]
result = []
def compression(x, y, N):
  global result
  point = video[x][y]
  for i in range(x, x+N):
    for j in range(y, y+N):
      if video[i][j] != point:
        result.append('(')
        compression(x, y, N//2)
        compression(x, y+N//2, N//2)
        compression(x+N//2, y, N//2)
        compression(x+N//2, y+N//2, N//2)
        result.append(')')
        return
  result.append(point)

compression(0, 0, n)
print("".join(map(str, result))) #리스트를 문자열로 바꿔주는
