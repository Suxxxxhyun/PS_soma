from itertools import combinations_with_replacement
n, m = map(int, input().split())
num = [i for i in range(1, n + 1)]
for c in combinations_with_replacement(num, m):
    for i in c:
        print(i, end=' ')
    print()
