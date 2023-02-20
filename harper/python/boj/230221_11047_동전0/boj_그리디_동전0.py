n, k = map(int, input().split())
coins = []

for i in range(n):
  coins.append(int(input()))
coins.sort(reverse=True)

result = 0
left = 0
for coin in coins:
  if k == 0:
    break
  if coin <= k:
    result += k // coin
    left = k % coin
    k = left

print(result)
