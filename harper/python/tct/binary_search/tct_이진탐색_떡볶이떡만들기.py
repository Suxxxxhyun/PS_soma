n, m = map(int, input().split())
ttok = [list(map(int, input().split()))]
sum = 0
while start<=end:
    mid = (start + end) // 2
    for i in ttok:
      if i>mid:
        sum += i - mid
    if ttok[mid] < m:
      end = mid - 1
    else:
      sum = mid
      start = mid + 1

print(sum)
