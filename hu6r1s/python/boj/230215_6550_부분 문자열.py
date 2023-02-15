while True:
    try:
        s, t = input().split()
        count = 0
        flag = 0
        for i in range(len(t)):
            if t[i] == s[count]:
                count += 1
                if count == len(s):
                    flag = 1
                    break
        if flag == 1:
            print('Yes')
        else:
            print('No')
    except:
        break
