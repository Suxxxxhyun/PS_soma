import heapq
n = int(input())
heap = []

for i in range(n):
  heapq.heappush(heap, int(input()))

result = 0
#원소가 하나 남을떄까지 계속 더할 거임
while len(heap) != 1:
  one = heapq.heappop(heap)
  two = heapq.heappop(heap)
  heapq.heappush(heap, one+two)
  result += one+two

print(result)
