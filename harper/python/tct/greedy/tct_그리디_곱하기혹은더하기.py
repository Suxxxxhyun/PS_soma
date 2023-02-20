number = input()

sum = int(number[0])

for i in range(1, len(number)):
  num = int(number[i])
  if num <= 1 or sum <= 1:
    sum += num
  else:
    sum *= num
