n, m = map(int, input().split())
cnt = [0] * 11

for x in cnt:
  cnt[x] += 1

result = 0
for i in range(1, m+1):
  n -= cnt[i] #이미 계산했던 경우는 제외
  result += cnt[i] * n #B가 선택하는 경우의 수

print(result)
