'''
다시 풀이 해볼 것.
'''
k, n = map(int, input().split())
k_list = [int(input()) for _ in range(k)]
start = 1
end = max(k_list)
while start <= end:
    mid = (start + end) // 2
    line = 0
    for i in k_list:
        line += i // mid
    if line >= n:
        start = mid + 1
    else:
        end = mid - 1
print(end)
