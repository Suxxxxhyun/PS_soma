r, c, t = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(r)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

air_cleaner = 0

for i in range(r):
  for j in range(c):
    if room[i][j] == -1:
      air_cleaner = i
      break
  if air_cleaner != 0:
    break

for i in range(t):
  #spread_dust
  dust_room = [[0] * c for _ in range(r)]
  for i in range(r):
    for j in range(c):
      if room[i][j] != 0 and room[i][j] != -1:
        cnt = 0
        for k in range(4):
          nr = i + dr[k]
          nc = j + dc[k]
          if 0<=nr<r and 0<=nc<c and room[nr][nc] != -1:
            dust_room[nr][nc] += room[i][j] // 5
            cnt += 1
        room[i][j] -= (room[i][j] // 5) * cnt

  for i in range(r):
    for j in range(c):
      room[i][j] += dust_room[i][j]

  #spread_air
  for i in range(air_cleaner, 0, -1): room[i][0] = room[i-1][0]
  for i in range(0,c-1): room[0][i] = room[0][i+1]
  for i in range(0, air_cleaner): room[i][c-1] = room[i+1][c-1]
  for i in range(c-1, 0, -1): room[air_cleaner][i] = room[air_cleaner][i-1]
  room[air_cleaner][1] = 0

  air_cleaner += 1

  for i in range(air_cleaner, r-1): room[i][0] = room[i+1][0]
  for i in range(0, c-1): room[r-1][i] = room[r-1][i+1]
  for i in range(r-1, air_cleaner, -1): room[i][c-1] = room[i-1][c-1]
  for i in range(c-1, 0, -1): room[air_cleaner][i] = room[air_cleaner][i-1]
  room[air_cleaner][1] = 0

sum = 0
for i in range(r):
  for j in range(c):
    sum += room[i][j]

print(sum)
