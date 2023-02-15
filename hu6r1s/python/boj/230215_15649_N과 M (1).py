from itertools import permutations
n, m = map(int, input().split())
num = [i for i in range(1, n + 1)]
for p in permutations(num, m):
    for i in p:
        print(i, end=' ')
    print()
