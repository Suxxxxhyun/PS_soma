'''
n = int(input())
distance = list(map(int, input().split()))
price = list(map(int, input().split()))
min_idx = price.index(min(price[:-1]))
c = distance[0] * price[0]
print(c + (sum(distance[1:]) * price[min_idx]))
해당 코드로 풀이했었는데 17점이라고 뜬다..
'''
n = int(input())
distance = list(map(int, input().split()))
price = list(map(int, input().split()))
result = distance[0] * price[0]
min_price = price[0]
for i in range(1,  n - 1):
    if min_price > price[i]:
        min_price = price[i]

    result += min_price * distance[i]
print(result)
