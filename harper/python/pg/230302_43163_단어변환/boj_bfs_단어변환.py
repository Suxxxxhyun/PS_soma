'''
1. 변환 과정에 cnt를 증가시켜가며 최소 변환 횟수를 리턴 -> bfs 생각
2. 변환 할 수 있는 단어의 기준 -> 기존 단어와 한글자 차이, 길이랑 위치 모두 비슷하기 때문에 diff_cnt로 판단
3. 변환 가능한 단어를 계속 큐에 넣어가며 결국 최종 변환한 단어와 타겟이 같으면 cnt 리턴
'''
from collections import deque
def solution(begin, target, words):
  if target not in words:
    return 0

  queue = deque()
  queue.append((begin, 0))

  while queue:
    start_str, cnt = queue.popleft()
    if start_str == target:
      return cnt
    for word in words:
      diff_cnt = 0
      for idx in range(len(word)):
        if word[idx] != start_str[idx]:
          diff_cnt += 1
      if diff_cnt == 1:
        queue.append((word, cnt + 1))

