from itertools import product
n, m = map(int, input().split())
num = [i for i in range(1, n + 1)]
for p in product(num, repeat=m):
    for i in p:
        print(i, end=' ')
    print()
