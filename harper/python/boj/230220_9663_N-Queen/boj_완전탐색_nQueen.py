n = int(input())
board = [0] * n
visited= [False] * n
def check(n):
  for i in range(n):
    if (board[n] == board[i]) or (n-i == abs(board[i] - board[n])): #행의 차이가 1칸으로 있는 경우 == 대각선
      return False
  return True

def nqueen(depth): #열
  global result

  if depth == n:
    result += 1
    return

  for i in range(n):
    if visited[i] == False:
      board[depth] = i

      if check(depth):
        visited[i] = True
        nqueen(depth + 1)
        visited[i] = False

result = 0
nqueen(0)
print(result)
