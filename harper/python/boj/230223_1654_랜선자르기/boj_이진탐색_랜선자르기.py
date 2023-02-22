k, n = map(int, input().split())
lan = []
for i in range(k):
  lan.append(int(input()))

lan.sort()
start = 1 # 길이를 기준으로 개수를 확인하는 것
end = lan[-1]

while start<=end:
  mid = (start+end) // 2
  sum_value = 0

  for cable in lan:
    sum_value += cable//mid

  if sum_value >= n: #타겟을 찾았어도 최대길이가 아닐 수 있으므로 탐색을 끝까지 해야한다
    start = mid + 1
  else:
    end = mid - 1
print(end)
