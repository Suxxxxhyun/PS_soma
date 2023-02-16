from itertools import permutations

n = int(input())
number = list(map(int, input().split()))
operator = list(map(int, input().split()))

op = '+' * operator[0] + '-' * operator[1] + '*' * operator[2] + '/' * operator[3]
op_set = list(set(permutations(op, n-1)))

def calculate(op):
  idx = 0
  sum_value = number[idx]
  for i in op:
    if i == '+':
      sum_value += number[idx+1]
    elif i == '-':
      sum_value -= number[idx+1]
    elif i == '*':
      sum_value *= number[idx+1]
    elif i == '/':
      sum_value = int(sum_value/number[idx+1])
    idx += 1
  return sum_value

result = []
for i in op_set:
  result.append(calculate(i))

print(max(result))
print(min(result))
