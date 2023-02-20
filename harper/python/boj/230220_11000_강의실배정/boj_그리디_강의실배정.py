import heapq
heap = [] #우선순위 큐에 넣는게 강의실의 개수
'''
우선순위 큐 = 우선순위가 높은 데이터를 먼저 삭제하는 자료구조 

'''
n = int(input())
time = [[0] * 2 for _ in range(n)]
for i in range(n):
  start, end = map(int, input().split())
  time[i][0] = start
  time[i][1] = end

time.sort() #오름차순 정렬

heapq.heappush(heap, time[0][1]) #강의가 끝난 시간만 담음

for i in range(1, n):
  if heap[0] > time[i][0]: #끝나는 시간이 다음 시작시간보다 클 경우 끝나는 시간을 추가
    heapq.heappush(heap, time[i][1])
  else: #끝나는 시간이 다음 시작시간보다 작거나 같다면 강의를 할 수 있기 때문에 제거하고 새 시간을 추가함(뒷시간이 더 길거니까 뺴고 새로 추가)
    heapq.heappop(heap)
    heapq.heappush(heap, time[i][1])

print(len(heap))


