
'''
0에 인접한 칸과 이동할 수 있으면서 최소 이동 횟수를 구함 -> bfs생각
2차원 좌표로 생각하기 어려우니 str 형태로 저장 -> 리스트 대신 문자열로 저장, 딕셔너리에 str형태로 저장 **

'''
from collections import deque
puzzle = ""
for i in range(3):
  a, b, c = map(str, input().split())
  puzzle += a+b+c

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def bfs():
  queue = deque()
  queue.append((puzzle)) #문자열 형태로 저장
  visited[puzzle] = 0 #딕셔너리 형태면 문자열을 key로 저장가능함

  while queue:
    target = queue.popleft()
    if target == "123456780":
      return visited[target]

    index = target.find("0") #현재 0의 좌표값 구하기
    x, y = index // 3, index % 3

    for i in range(4): #상하좌우 팀섹
      nx = x + dx[i]
      ny = y + dy[i]

      if 0<=nx<3 and 0<=ny<3:
        n = nx * 3 + ny #배열 좌표값에서 문자열 형태의 인덱스로 바꾸기 위해
        list_target = list(target) # swap을 위해 리스트로 변환
        list_target[index], list_target[n] = list_target[n], list_target[index] #swap
        new_target = "".join(list_target)

        if not visited.get(new_target): #문자열 형태로 바꿔 현재 딕셔너리에 저장되어있는 포맷이 아니면 저장
          visited[new_target] = visited[target] + 1 #현재 포맷에 저장된 cnt 개수 증가 후 저장
          queue.append(new_target)

  return -1 #이동이 불가능할 경우 -1

visited = dict() #정답 포맷을 저장 할 딕셔너리
print(bfs())

