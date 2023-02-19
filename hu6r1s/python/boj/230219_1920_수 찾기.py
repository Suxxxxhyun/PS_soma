'''
그냥 반복문으로 완전탐색하면 시간초과가 뜬다.
이진탐색으로 풀어야 함.
근데 안풀림..
'''
import sys
input = sys.stdin.readline

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return True
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return False

n = int(input())
a = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))
for i in m_list:
    if binary_search(a, i, 0, n - 1):
        print(1)
    else:
        print(0)
