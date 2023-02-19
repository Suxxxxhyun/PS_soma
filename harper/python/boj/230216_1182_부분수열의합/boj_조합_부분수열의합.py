from itertools import combinations
n, s = map(int, input().split())
num = list(map(int, input().split()))
result = 0

for i in range(1, n+1):
  candidates = list(combinations(num, i))
  for candidate in candidates:
   if sum(candidate) == s:
     result += 1

print(result)

