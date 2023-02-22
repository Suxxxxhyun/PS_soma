import sys
input = sys.stdin.readline().rstrip()
n = int(input())
part = [list(map(int, input().split()))]
part.sort()
m = int(input())
request = [list(map(int, input().split()))]

def binary_search(part, target, start, end):
  while start<=end:
    mid = (start + end) // 2
    if part[mid] == target:
      return mid
    elif part[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  return None

for i in request:
  result = binary_search(part, i, 0, n-1)
  if result != None:
    print('yes', end=' ')
  else:
    print('no', end = ' ')
