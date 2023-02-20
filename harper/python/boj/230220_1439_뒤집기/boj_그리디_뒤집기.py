number = input()
toZero = 0
toOne = 0
if number[0] == '1':
  toZero += 1
else:
  toOne += 1

for i in range(1, len(number)-1):
  if number[i] != number[i+1]:
    if number[i+1] == '1':
      toZero+=1
    else:
      toOne+=1

print(min(toZero, toOne))

