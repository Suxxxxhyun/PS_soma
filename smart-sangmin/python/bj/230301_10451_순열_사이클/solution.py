"""
2
8
3 2 7 8 1 4 5 6
10
2 1 3 4 5 6 7 9 10 8
"""


def check_cycle(num, start_num):
    visited[num] = True
    if num == start_num:
        return
    check_cycle(nums[num], start_num)


T = int(input())
for _ in range(T):
    N = int(input())
    nums = [0] + list(map(int, input().split(" ")))
    visited = [False] + [False] * N
    cnt = 0
    for i in range(1, N+1):
        if not visited[i]:
            check_cycle(nums[i], i)
            cnt += 1
    print(cnt)
