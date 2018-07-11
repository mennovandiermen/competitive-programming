import sys

inp = sys.stdin

x = int(inp.readline())
i = 0

while i<x:
    line = inp.readline().lower()
    missing = ""
    for c in range(ord('a'), ord('z')+1):
        if chr(c) not in line:
            missing += (chr(c))
    if len(missing) < 1:
        print("pangram")
    else:
        print("missing " + missing)
    i = i+1