from bisect import bisect_left, bisect_right

n, x = map(int, input().split())
arr = list(map(int, input().split()))

def calCountsByRange(arr, left_value,  right_value):
  right_index = bisect_right(arr, right_value)
  left_index = bisect_left(arr, left_value)
  return right_index - left_index

count = calCountsByRange(arr, x, x)

if count == 0:
  print(-1)
else:
  print(count)

