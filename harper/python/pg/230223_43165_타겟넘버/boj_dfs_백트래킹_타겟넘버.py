sum = 0
answer = 0

def solution(numbers, target):
  def dfs(idx):
    global sum, answer
    if idx == len(numbers):
      if sum == target:
        answer += 1
      return

    sum += numbers[idx]
    dfs(idx+1)
    sum -= numbers[idx]

    sum -= numbers[idx]
    dfs(idx+1)
    sum += numbers[idx]

  dfs(0)
  return answer
