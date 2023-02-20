'''
a<b+c이면 삼각형
'''
import sys
input = sys.stdin.readline

n = int(input())
triangle = []
for i in range(n):
  triangle.append(int(input()))

triangle.sort(reverse=True) #역순으로 정렬해야 조건에 맞는 값이 나오면 최댓값이 됨

for i in range(n-2):
  if triangle[i] < triangle[i+1] + triangle[i+2]:
    print(triangle[i] + triangle[i+1] + triangle[i+2])
    exit()
print(-1)

