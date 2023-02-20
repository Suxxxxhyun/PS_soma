'''
그냥 반복문으로 완전탐색하면 시간초과가 뜬다.
이진탐색으로 풀어야 함.
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
이렇게 코드를 짰는데 제대로 출력이 안된다.
확인해보니깐 a리스트를 정렬해야한다..
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

n = int(input())
a = list(map(int, input().split()))
a.sort()
m = int(input())
m_list = list(map(int, input().split()))
for i in m_list:
    if binary_search(a, i, 0, n - 1):
        print(1)
    else:
        print(0)
