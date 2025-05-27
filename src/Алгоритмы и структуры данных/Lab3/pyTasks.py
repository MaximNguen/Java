flag = False
a = []
for _ in range(int(input())):
    a.append(int(input()))
target = int(input())
for i in range(len(a)):
    for j in range(i+1, len(a)):
        if a[i] * a[j] == target:
            flag = True
if flag:
    print("ДА")
else:
    print("НЕТ")