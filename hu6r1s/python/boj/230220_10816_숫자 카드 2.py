'''
import sys
input = sys.stdin.readline

def binary(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return True
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

n = int(input())
n_list = list(map(int, input().split()))
n_list.sort()
m = int(input())
m_list = list(map(int, input().split()))
for i in m_list:
    if binary(n_list, i, 0, m - 1):
        print(n_list.count(i), end=' ')
    else:
        print(0, end=' ')
이진 탐색을 하고 count함수를 이용해서 개수를 출력했다..
근데 시간 초과가 나서 블로깅하니 Counter모듈을 사용한다.
'''
import sys
from collections import Counter
input = sys.stdin.readline

def binary(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return True
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1

n = int(input())
n_list = list(map(int, input().split()))
n_list.sort()
m = int(input())
m_list = list(map(int, input().split()))
count = Counter(n_list)
for i in m_list:
    if binary(n_list, i, 0, m - 1):
        print(count[i], end=' ')
    else:
        print(0, end=' ')
