from datetime import datetime

lines = 1;
while(lines is not 0):
	lines = int(raw_input())
	times = []
        for i in range(0, lines):
		time = raw_input().replace("a.m.", "am").replace("p.m.", "pm")
		times.append(datetime.strptime(time, "%I:%M %p"))
	times.sort()
	for j in range(0, lines):
		time = times[j].strftime("%I:%M %p").replace("AM", "a.m.").replace("PM", "p.m.")
		if time[0] == '0':
			time = time[1:]
		print(time)
