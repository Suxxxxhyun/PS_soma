import heapq
'''
우선순위 큐 
들어온 기준(끝나는 시간)이 작은 순서대로 계속 정렬되어서 들어가고 
가장 앞에 있는(가장 작은 값)이 pop되어서 나옴 
'''
n = int(input())
schedule = [list(map(int, input().split())) for _ in range(n)]
schedule.sort(key=lambda x: x[1]) #시작시간 기준으로 정렬

heap = []
result = 0
#print(schedule)
#print()
for i in schedule:
  while heap and heap[0] <= i[1]: #기존 강의실 사용
    heapq.heappop(heap)
  heapq.heappush(heap, i[2]) # 새 강의실 추가
  #print(heap)
  result = max(result, len(heap))
print(result)


