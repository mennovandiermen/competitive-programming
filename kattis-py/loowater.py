import sys

inp = sys.stdin
for line in inp:
    doom = False
    l = line.split()
    n = int(l[0])
    m = int(l[1])
    if n == 0 and m == 0:
        exit()
    if n > m:
        doom = True

    heads = []
    for i in range(0, n):
        heads.append(int(inp.readline()))
    knights = []
    for j in range(0, m):
        knights.append(int(inp.readline()))

    gold = 0
    heads.sort()
    knights.sort()

    l = 0
    for k in range(0, n):
        while l < m and knights[l] < heads[k]:
            l += 1

        if l == m:
            doom = True
            break
        else:
            gold += knights[l]
            l += 1

    if doom:
        print("Loowater is doomed!")
    else:
        print(gold)
