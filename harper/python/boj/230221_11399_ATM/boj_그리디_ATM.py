n = int(input())
time = list(map(int, input().split()))
time.sort() # 앞 사람이 걸리는 시간이 적게 들어야하니까

result = 0
sum = 0
for i in time:
  sum += i
  result += sum

print(result)




