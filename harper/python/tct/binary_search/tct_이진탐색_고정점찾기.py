n = int(input())
numbers = list(map(int, input().split()))

start = 0
end = n-1
chk = False

while start<=end:
  mid = (start+end) // 2
  if numbers[mid] == mid:
    print(mid)
    chk = True
    break

  if numbers[mid] < mid:
    start = mid + 1
  else:
    end = mid - 1

if not chk:
  print(-1)
